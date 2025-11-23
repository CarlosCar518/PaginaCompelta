/*

Tooplate 2141 Minimal White

https://www.tooplate.com/view/2141-minimal-white

*/

// JavaScript Document

// Mobile menu toggle
const menuToggle = document.getElementById('menuToggle');
const navLinks = document.getElementById('navLinks');

menuToggle.addEventListener('click', function () {
    menuToggle.classList.toggle('active');
    navLinks.classList.toggle('active');
});

// Close mobile menu when link is clicked
document.querySelectorAll('.nav-link').forEach(link => {
    link.addEventListener('click', function () {
        menuToggle.classList.remove('active');
        navLinks.classList.remove('active');
    });
});

// Navbar scroll effect and active menu highlighting
const sections = document.querySelectorAll('section');
const navItems = document.querySelectorAll('.nav-link');

window.addEventListener('scroll', function () {
    const navbar = document.getElementById('navbar');

    // Navbar style on scroll
    if (window.scrollY > 50) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }

    // Active menu highlighting
    let current = '';
    sections.forEach(section => {
        const sectionTop = section.offsetTop;
        const sectionHeight = section.clientHeight;
        if (scrollY >= (sectionTop - 100)) {
            current = section.getAttribute('id');
        }
    });

    navItems.forEach(item => {
        item.classList.remove('active');
        if (item.getAttribute('href').slice(1) === current) {
            item.classList.add('active');
        }
    });
});

// Trigger scroll event on load to set initial active state
window.dispatchEvent(new Event('scroll'));

// Smooth scrolling for navigation links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});

// Fade in animation on scroll
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -50px 0px'
};

const observer = new IntersectionObserver(function (entries) {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('visible');
        }
    });
}, observerOptions);

document.querySelectorAll('.fade-in').forEach(el => {
    observer.observe(el);
});

// Form submission (prevent default for demo)
document.querySelector('form').addEventListener('submit', function (e) {
    e.preventDefault();
    alert('Message sent successfully!');
    this.reset();
});

document.addEventListener('DOMContentLoaded', () => {
    const miCuadradito = document.getElementById("cuadradito");

    let isDragging = false;
    let offsetX = 0;
    let offsetY = 0;

    if (miCuadradito) {
        miCuadradito.style.position = 'absolute';
        miCuadradito.style.cursor = 'grab';

        miCuadradito.addEventListener('mousedown', (e) => {
            isDragging = true;

            offsetX = e.clientX - miCuadradito.offsetLeft;
            offsetY = e.clientY - miCuadradito.offsetTop;

            miCuadradito.style.cursor = 'grabbing';

            e.preventDefault();
        });

        document.addEventListener('mousemove', (e) => {
            if (!isDragging) return;

            const newX = e.clientX - offsetX;
            const newY = e.clientY - offsetY;

            miCuadradito.style.left = newX + 'px';
            miCuadradito.style.top = newY + 'px';
        });

        document.addEventListener('mouseup', () => {
            isDragging = false;
            miCuadradito.style.cursor = 'grab';
        })
    }
})

// Functions for adoption/accessories forms (dynamic accessory rows + receipt prompt)
function showAnimalDetails() {
    const sel = document.getElementById('animal-select');
    if (!sel) return;
    const opt = sel.options[sel.selectedIndex];

    const age = opt ? (opt.dataset.age || '--') : '--';
    const gender = opt ? (opt.dataset.gender || '--') : '--';
    const image = opt ? (opt.dataset.image || '') : '';
    const history = opt ? (opt.dataset.history || '') : '';

    const ageEl = document.getElementById('animal-age');
    const genderEl = document.getElementById('animal-gender');
    const imgEl = document.getElementById('animal-image');
    const historyEl = document.getElementById('animal-history');

    if (ageEl) ageEl.textContent = age;
    if (genderEl) genderEl.textContent = gender;

    if (imgEl) {
        if (image) {
            imgEl.src = image;
            imgEl.alt = sel.options[sel.selectedIndex].text || 'Animal';
            imgEl.style.display = '';
        } else {
            imgEl.style.display = 'none';
        }
    }

    if (historyEl) {
        historyEl.textContent = history || 'No hay historia disponible para este animal.';
    }
}

function formatCurrency(n) {
    return '$' + Number(n).toFixed(2);
}

function updateAccessoryRow(row) {
    const sel = row.querySelector('.accessory-select');
    const qtyInput = row.querySelector('.accessory-quantity');
    const priceEl = row.querySelector('.accessory-price');
    const totalEl = row.querySelector('.accessory-total');

    if (!sel) return;
    const opt = sel.options[sel.selectedIndex];
    const priceText = opt ? (opt.dataset.price || '--') : '--';
    if (priceEl) priceEl.textContent = priceText;

    let unit = 0;
    if (priceText && priceText !== '--') unit = parseFloat(priceText.replace(/[^0-9.-]+/g, '')) || 0;

    const qty = qtyInput ? Math.max(1, parseInt(qtyInput.value) || 1) : 1;
    if (totalEl) {
        if (unit) {
            totalEl.textContent = formatCurrency(unit * qty);
        } else {
            totalEl.textContent = '--';
        }
    }

    updateGrandTotal();
}

function updateGrandTotal() {
    const rows = document.querySelectorAll('.accessory-item');
    let grand = 0;
    rows.forEach(r => {
        const totalEl = r.querySelector('.accessory-total');
        if (totalEl) {
            const txt = totalEl.textContent || '';
            const num = parseFloat(txt.replace(/[^0-9.-]+/g, '')) || 0;
            grand += num;
        }
    });
    const grandEl = document.getElementById('accessories-grand-total');
    if (grandEl) grandEl.textContent = grand ? formatCurrency(grand) : '--';
}

function bindAccessoryRow(row) {
    const sel = row.querySelector('.accessory-select');
    const qtyInput = row.querySelector('.accessory-quantity');
    const removeBtn = row.querySelector('.remove-accessory');

    if (sel) sel.addEventListener('change', () => updateAccessoryRow(row));
    if (qtyInput) qtyInput.addEventListener('input', () => updateAccessoryRow(row));

    if (removeBtn) {
        removeBtn.addEventListener('click', () => {
            const container = document.getElementById('accessory-items');
            row.remove();
            // if only one left, hide its remove button
            const remaining = container.querySelectorAll('.accessory-item');
            if (remaining.length === 1) {
                const btn = remaining[0].querySelector('.remove-accessory');
                if (btn) btn.style.display = 'none';
            }
            updateGrandTotal();
        });
    }
}

function addAccessoryRow() {
    const tpl = document.getElementById('accessory-item-template');
    const container = document.getElementById('accessory-items');
    if (!tpl || !container) return;
    const clone = tpl.content.firstElementChild.cloneNode(true);
    container.appendChild(clone);
    const rows = container.querySelectorAll('.accessory-item');
    // show remove button for all if >1
    rows.forEach(r => {
        const btn = r.querySelector('.remove-accessory');
        if (btn) btn.style.display = rows.length > 1 ? '' : 'none';
    });
    bindAccessoryRow(clone);
    updateAccessoryRow(clone);
}

// Initialize accessory UI and submit behavior
document.addEventListener('DOMContentLoaded', () => {
    const animalSelect = document.getElementById('animal-select');
    if (animalSelect) animalSelect.addEventListener('change', showAnimalDetails);

    // Setup add accessory button
    const addBtn = document.getElementById('add-accessory');
    if (addBtn) addBtn.addEventListener('click', addAccessoryRow);

    // Create initial accessory row
    addAccessoryRow();

    // Submit handling
    const submitBtn = document.getElementById('submit-request');
    if (submitBtn) {
        submitBtn.addEventListener('click', function () {
            const animalSel = document.getElementById('animal-select');
            const animal = (animalSel && animalSel.value) ? animalSel.options[animalSel.selectedIndex].text : null;
            if (!animal) {
                alert('Por favor selecciona un animal antes de enviar la solicitud.');
                return;
            }

            const rows = document.querySelectorAll('.accessory-item');
            const accessories = [];
            const outOfStock = [];

            rows.forEach(r => {
                const sel = r.querySelector('.accessory-select');
                const qtyInput = r.querySelector('.accessory-quantity');
                if (!sel) return;
                const opt = sel.options[sel.selectedIndex];
                const name = opt ? opt.text : 'Ninguno';
                const unitText = opt ? (opt.dataset.price || '--') : '--';
                const unit = unitText && unitText !== '--' ? parseFloat(unitText.replace(/[^0-9.-]+/g, '')) || 0 : 0;
                const qty = qtyInput ? Math.max(1, parseInt(qtyInput.value) || 1) : 1;
                const stock = opt ? parseInt(opt.dataset.stock || '0') : 0;
                const total = unit * qty;
                accessories.push({ name, unit, qty, total, stock });
                if (qty > stock) outOfStock.push({ name, requested: qty, stock });
            });

            if (outOfStock.length) {
                const list = outOfStock.map(i => `${i.name} (solicitado: ${i.requested}, en stock: ${i.stock})`).join('\n');
                alert('Algunos artículos no están en stock:\n' + list);
                return;
            }

            // All in stock — ask about receipt download
            const proceed = confirm('Todos los artículos están en stock. ¿Deseas descargar el recibo de la compra? (no implementado)');
            if (proceed) {
                alert('Función de descarga de recibo no implementada aún.');
            } else {
                alert('Solicitud procesada. Nos pondremos en contacto contigo pronto.');
            }
        });
    }

    // Initialize animal details on load
    showAnimalDetails();
});

