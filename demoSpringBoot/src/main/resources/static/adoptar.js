// Data
const pets = [
    {
        id: 'max',
        name: 'Max',
        type: 'Perro',
        age: '2 años',
        image: 'images/david-lezcano-m-Doa-GTrUw-unsplash.jpg',
        story: 'Max fue rescatado de la calle y es muy juguetón; le encanta pasear y recibir caricias. Es un compañero leal que busca un hogar lleno de amor.'
    },
    {
        id: 'luna',
        name: 'Luna',
        type: 'Gato',
        age: '4 meses',
        image: 'images/gatito-removebg-preview.png',
        story: 'Luna llegó desde un pequeño refugio; es curiosa y le encanta dormir en cajas pequeñas. Perfecta para un apartamento tranquilo.'
    },
    {
        id: 'saltarin',
        name: 'Saltarín',
        type: 'Conejo',
        age: '1 año',
        image: 'images/veterinarias-en-cali.webp',
        story: 'Saltarín es un conejo tranquilo que disfruta comer heno y explorar su zona segura. Ideal para familias con niños.'
    }
];

const accessories = [
    {
        id: 'collar',
        name: 'Collar de Lujo',
        price: 25.00,
        image: 'images/collar.jpg', // Placeholder path
        description: 'Un collar resistente y elegante para tu mascota. Ajustable y cómodo.'
    },
    {
        id: 'cama',
        name: 'Cama Suave',
        price: 40.50,
        image: 'images/cama.jpg', // Placeholder path
        description: 'La cama más suave para que tu amigo duerma como un rey. Lavable a máquina.'
    },
    {
        id: 'pelota',
        name: 'Pelota Interactiva',
        price: 5.99,
        image: 'images/pelota.jpg', // Placeholder path
        description: 'Diversión garantizada. Rebota y es resistente a mordidas.'
    }
];

let selectedPet = null;
let cart = [];

// DOM Elements
document.addEventListener('DOMContentLoaded', () => {
    initPetList();
    initAccessories();
    updateCart();

    // Mobile menu logic (copied from main script for consistency)
    const menuToggle = document.getElementById('menuToggle');
    const navLinks = document.getElementById('navLinks');
    if (menuToggle) {
        menuToggle.addEventListener('click', () => {
            menuToggle.classList.toggle('active');
            navLinks.classList.toggle('active');
        });
    }

    document.getElementById('closePanel').addEventListener('click', () => {
        document.getElementById('accessoryPanel').style.display = 'none';
    });

    document.getElementById('addToCartBtn').addEventListener('click', addToCart);
    document.getElementById('finalizeBtn').addEventListener('click', finalizeOrder);
});

function initPetList() {
    const list = document.getElementById('petList');
    pets.forEach(pet => {
        const li = document.createElement('li');
        li.textContent = pet.name;
        li.addEventListener('click', () => showPetDetails(pet));
        list.appendChild(li);
    });
}

function showPetDetails(pet) {
    selectedPet = pet;
    const display = document.getElementById('petDisplay');

    // Highlight selected in list
    document.querySelectorAll('.pet-list li').forEach(li => {
        li.classList.remove('active');
        if (li.textContent === pet.name) li.classList.add('active');
    });

    display.innerHTML = `
        <div class="pet-card fade-in">
            <div class="pet-image">
                <img src="${pet.image}" alt="${pet.name}">
            </div>
            <div class="pet-info">
                <h2>${pet.name} <span class="pet-type">(${pet.type})</span></h2>
                <p class="pet-age">Edad: ${pet.age}</p>
                <p class="pet-story">${pet.story}</p>
                <button class="cta-button" onclick="scrollToAccessories()">Elegir Accesorios</button>
            </div>
        </div>
    `;
}

function scrollToAccessories() {
    document.getElementById('accessoriesSection').scrollIntoView({ behavior: 'smooth' });
}

function initAccessories() {
    loadAccessories();

    const loadMoreBtn = document.getElementById('loadMoreBtn');
    if (loadMoreBtn) {
        loadMoreBtn.addEventListener('click', loadMoreAccessories);
    }
}

let currentAccessoryCount = 0;
const ITEMS_PER_PAGE = 8;

function loadAccessories() {
    const grid = document.getElementById('accessoriesGrid');
    const loadMoreContainer = document.getElementById('loadMoreContainer');

    const nextBatch = accessories.slice(currentAccessoryCount, currentAccessoryCount + ITEMS_PER_PAGE);

    nextBatch.forEach(acc => {
        const card = document.createElement('div');
        card.className = 'accessory-card';
        card.innerHTML = `
            <h4>${acc.name}</h4>
            <p class="price">$${acc.price.toFixed(2)}</p>
        `;
        card.addEventListener('click', () => showAccessoryPanel(acc));
        grid.appendChild(card);
    });

    currentAccessoryCount += nextBatch.length;

    // Show/Hide Load More button
    if (loadMoreContainer) {
        if (currentAccessoryCount < accessories.length) {
            loadMoreContainer.style.display = 'block';
        } else {
            loadMoreContainer.style.display = 'none';
        }
    }
}

function loadMoreAccessories() {
    loadAccessories();
}

let currentAccessory = null;

function showAccessoryPanel(acc) {
    currentAccessory = acc;
    const panel = document.getElementById('accessoryPanel');

    document.getElementById('accDetailName').textContent = acc.name;
    document.getElementById('accDetailPrice').textContent = `$${acc.price.toFixed(2)}`;
    document.getElementById('accDetailDesc').textContent = acc.description;
    // Note: Using a placeholder image logic if real image fails or just using the text
    document.getElementById('accDetailImage').src = acc.image;
    document.getElementById('accDetailImage').alt = acc.name;

    panel.style.display = 'block';
}

function addToCart() {
    if (!currentAccessory) return;

    const qty = parseInt(document.getElementById('accDetailQty').value) || 1;

    const existing = cart.find(item => item.id === currentAccessory.id);
    if (existing) {
        existing.qty += qty;
    } else {
        cart.push({ ...currentAccessory, qty });
    }

    updateCart();
    document.getElementById('accessoryPanel').style.display = 'none';
    alert('Accesorio añadido al carrito');
}

function updateCart() {
    const container = document.getElementById('cartItems');
    const totalEl = document.getElementById('cartTotal');

    if (cart.length === 0 && !selectedPet) {
        container.innerHTML = '<p>No has seleccionado nada aún.</p>';
        totalEl.textContent = '$0.00';
        return;
    }

    let html = '';
    let total = 0;

    if (selectedPet) {
        html += `<div class="cart-item pet-item">
            <span>Mascota: <strong>${selectedPet.name}</strong></span>
            <span>Adopción</span>
        </div>`;
    }

    cart.forEach(item => {
        const itemTotal = item.price * item.qty;
        total += itemTotal;
        html += `<div class="cart-item">
            <span>${item.name} x${item.qty}</span>
            <span>$${itemTotal.toFixed(2)}</span>
        </div>`;
    });

    container.innerHTML = html;
    totalEl.textContent = '$' + total.toFixed(2);
}

function finalizeOrder() {
    if (!selectedPet && cart.length === 0) {
        alert('Por favor selecciona al menos una mascota o un accesorio.');
        return;
    }

    let msg = '¡Gracias por tu interés!\n\n';
    if (selectedPet) {
        msg += `Has iniciado el proceso de adopción para: ${selectedPet.name}\n`;
    }
    if (cart.length > 0) {
        msg += `\nAccesorios seleccionados (${cart.length} items).\n`;
    }

    msg += '\nNos pondremos en contacto contigo pronto.';
    alert(msg);
}
