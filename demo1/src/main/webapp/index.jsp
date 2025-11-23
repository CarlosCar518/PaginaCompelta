<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lucifer Sam</title>
    <link href="tooplate-minimal-white-style.css" rel="stylesheet">

    <!--

Tooplate 2141 Minimal White

https://www.tooplate.com/view/2141-minimal-white

Free HTML CSS Template

-->
</head>

<body>
    <!-- Navigation -->
    <nav id="navbar">
        <div class="nav-container">
            <a href="#home" class="logo">Veterinaria</a>
            <div class="menu-toggle" id="menuToggle">
                <span></span>
                <span></span>
                <span></span>
            </div>
            <ul class="nav-links" id="navLinks">
                <li><a href="#home" class="nav-link">INICIO</a></li>
                <li><a href="#about" class="nav-link">SOBRE NOSOTROS</a></li>
                <li><a href="#services" class="nav-link">SERVICIOS</a></li>
                <li><a href="#contact" class="nav-link">CONTACTO</a></li>
            </ul>
        </div>
    </nav>

    <!-- Section 1: Hero -->
    <section id="home" class="hero">
        <!-- Animated Objects (Reduced) -->
        <div class="floating-objects">
            <div class="floating-paw"></div>
            <div class="floating-paw"></div>
            <div class="floating-paw"></div>
            <div class="floating-fish"></div>
            <div class="floating-fish"></div>
            <div class="floating-line"></div>
            <div class="floating-cat-face"></div>
        </div>

        <div class="hero-decoration" id="cuadradito"></div>
        <div class="hero-content">
            <h1>Lucifer Sam</h1>
            <p class="subtitle">Veterinaria especializada y refugio de animales</p>
            <a href="#about" class="cta-button">EXPLORE</a>
        </div>
    </section>

    <!-- Section 2: About - Mixed Layouts -->
    <section id="about" class="about">
        <div class="container">
            <!-- Introduction with large quote -->
            <div class="about-intro fade-in">
                <div class="quote-block">
                    <span class="quote-mark">"</span>
                    <h3>La mejor manera de encontrarse a uno mismo es perderse en el servicio a los demás.</h3>
                    <div class="quote-author">
                        <span class="author-line"></span>
                        <p>Mahatma Gandhi</p>
                    </div>
                </div>
            </div>

            <div class="main-image-container">
                <img src="images/veterinarias-en-cali.webp" alt="Veterinarios atendiendo a un gato">
            </div>
            <div class="black-line"></div>
            <!-- Philosophy Section with offset layout -->
            <div class="philosophy-section fade-in">
                <div class="philosophy-header">
                    <h2>Filosofía</h2>
                    <div class="header-decoration"></div>
                </div>

                <div class="philosophy-content">
                    <div class="philosophy-main">
                        <p class="lead-text">Creemos que todo animal merece una oportunidad de tener una vida feliz
                            y en familia
                        </p>

                        <div class="philosophy-points">
                            <div class="point-item">
                                <span class="point-number">01</span>
                                <h4>Cuidado</h4>
                                <p>Tanto si es como para una revisión o una animal rescatado, damos el mejor de los
                                    cuidados</p>
                            </div>
                            <div class="point-item">
                                <span class="point-number">02</span>
                                <h4>Space to Breathe</h4>
                                <p>Let design elements have room to speak</p>
                            </div>
                            <div class="point-item">
                                <span class="point-number">03</span>
                                <h4>Intentional Choices</h4>
                                <p>Every decision has meaning and purpose</p>
                            </div>
                        </div>
                    </div>
                    <div class="philosophy-image">
                        <img src="images/david-lezcano-m-Doa-GTrUw-unsplash.jpg" alt="Perrito">
                    </div>
                </div>
            </div>



            <!-- Process Timeline -->
            <div class="process-timeline fade-in">
                <h2 class="section-subtitle">Our Process</h2>
                <div class="timeline-container">
                    <div class="timeline-line"></div>
                    <div class="timeline-item">
                        <div class="timeline-dot" id="cuadradito1"></div>
                        <div class="timeline-content">
                            <h4>Discover</h4>
                            <p>Understanding your essence</p>
                        </div>
                    </div>
                    <div class="timeline-item">
                        <div class="timeline-dot"></div>
                        <div class="timeline-content">
                            <h4>Reduce</h4>
                            <p>Removing the unnecessary</p>
                        </div>
                    </div>
                    <div class="timeline-item">
                        <div class="timeline-dot"></div>
                        <div class="timeline-content">
                            <h4>Refine</h4>
                            <p>Perfecting every detail</p>
                        </div>
                    </div>
                    <div class="timeline-item">
                        <div class="timeline-dot"></div>
                        <div class="timeline-content">
                            <h4>Deliver</h4>
                            <p>Bringing vision to life</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="black-line"></div>

            <!-- Section compra-->
            <section id="adopcion-accesorios" class="adopcion-accesorios">
                <div class="container">
                    <div class="header-adopcion fade-in">
                        <h2>🐶 Adopta y Equipa a tu Mejor Amigo 🐈</h2>
                        <p>
                            En nuestra misión, la adopción es el primer paso. El proceso es simple:
                        </p>
                        <ol>
                            <li>Conoce a Nuestros Animales: Revisa la lista de los animales disponibles para
                                encontrar a tu compañero ideal.</li>
                            <li>Formulario de Interés: Selecciona el animal deseado en el formulario de abajo para
                                ver sus detalles (edad y sexo).</li>
                            <li>Prepara su Hogar: Una vez confirmada tu solicitud, te ayudamos a elegir los
                                accesorios esenciales para su llegada.</li>
                        </ol>
                        <p>
                            ¡Cada adopción salva una vida y nos ayuda a continuar nuestra labor!
                        </p>
                    </div>

                    <div class="adopcion-grid">

                        <div class="form-card fade-in">
                            <h3>1. ¡Elige a tu Mascota!</h3>
                            <form id="adoption-form">
                                <div class="form-group">
                                    <label for="animal-select">Animales Disponibles:</label>
                                    <select id="animal-select" name="animal" required onchange="showAnimalDetails()">
                                        <option value="" disabled selected>Selecciona un animal</option>
                                        <option value="perro-max" data-age="2 años" data-gender="Macho"
                                            data-image="images/david-lezcano-m-Doa-GTrUw-unsplash.jpg"
                                            data-history="Max fue rescatado de la calle y es muy juguetón; le encanta pasear y recibir caricias.">
                                            Max (Perro)
                                        </option>
                                        <option value="gato-luna" data-age="4 meses" data-gender="Hembra"
                                            data-image="images/gatito-removebg-preview.png"
                                            data-history="Luna llegó desde un pequeño refugio; es curiosa y le encanta dormir en cajas pequeñas.">
                                            Luna (Gato)
                                        </option>
                                        <option value="conejo-saltarin" data-age="1 año" data-gender="Macho"
                                            data-image="images/veterinarias-en-cali.webp"
                                            data-history="Saltarín es un conejo tranquilo que disfruta comer heno y explorar su zona segura.">
                                            Saltarín
                                            (Conejo)</option>
                                    </select>
                                </div>

                                <div id="animal-details" class="details-box">
                                    <div class="animal-details-grid">
                                        <div class="animal-thumb">
                                            <img id="animal-image" src="images/david-lezcano-m-Doa-GTrUw-unsplash.jpg"
                                                alt="Imagen del animal">
                                        </div>
                                        <div class="animal-meta">
                                            <p>Edad: <span id="animal-age">--</span></p>
                                            <p>Sexo: <span id="animal-gender">--</span></p>
                                            <p class="animal-history" id="animal-history">Selecciona un animal para ver
                                                su historia.</p>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div class="form-card fade-in">
                            <h3>2. Accesorios Esenciales</h3>
                            <form id="accessories-form">
                                <!-- Template for accessory row -->
                                <template id="accessory-item-template">
                                    <div class="accessory-item">
                                        <div class="form-group">
                                            <label>Accesorios Disponibles:</label>
                                            <select class="accessory-select" required>
                                                <option value="" disabled selected>Selecciona un accesorio</option>
                                                <option value="collar-lujo" data-price="$25.00" data-stock="5">Collar de
                                                    Lujo</option>
                                                <option value="cama-suave" data-price="$40.50" data-stock="2">Cama Suave
                                                    Grande</option>
                                                <option value="juguete-pelota" data-price="$5.99" data-stock="20">Pelota
                                                    Interactiva</option>
                                            </select>
                                        </div>

                                        <div class="details-box accessory-item-details">
                                            <p>Precio unitario: <span class="accessory-price">--</span></p>
                                            <div class="quantity-row">
                                                <label>Cantidad:</label>
                                                <input type="number" class="accessory-quantity" min="1" value="1">
                                                <button type="button" class="remove-accessory"
                                                    title="Eliminar">×</button>
                                            </div>
                                            <p>Total: <span class="accessory-total">--</span></p>
                                        </div>
                                    </div>
                                </template>

                                <div id="accessory-items"></div>

                                <div class="accessory-actions" style="margin-top:16px;">
                                    <button type="button" id="add-accessory" class="submit-button">Agregar
                                        accesorio</button>
                                </div>

                                <div id="accessories-summary" class="details-box" style="margin-top:16px;">
                                    <p>Total general: <span id="accessories-grand-total">--</span></p>
                                </div>
                            </form>
                        </div>
                    </div>

                    <form action="${pageContext.request.contextPath}/hello" class="submit-action fade-in">
                        <p>Presiona enviar para confirmar tu interés en la adopción y los accesorios seleccionados.</p>
                        <button type="submit" id="submit-request" class="submit-button">Enviar Solicitud</button>
                    </form>

                </div>

                <!-- Section 3: Services - Asymmetric Grid -->
                <section id="services" class="services">
                    <div class="container">
                        <div class="services-header fade-in">
                            <h2>What We Do</h2>
                        </div>

                        <div class="asymmetric-grid fade-in">
                            <div class="service-large">
                                <h3>Brand Identity</h3>
                                <p>Creating distinctive visual languages that communicate your essence through
                                    simplicity.
                                    We
                                    develop comprehensive brand systems that stand the test of time.</p>
                                <a href="#contact" class="service-tag">View Work</a>
                            </div>
                            <div class="service-small">
                                <div class="service-number">01</div>
                                <h4>Strategy First</h4>
                            </div>
                        </div>

                        <div class="asymmetric-grid reverse fade-in">
                            <div class="service-small">
                                <div class="service-number">02</div>
                                <h4>Digital Native</h4>
                            </div>
                            <div class="service-large">
                                <h3>Web Design</h3>
                                <p>Crafting digital experiences that prioritize clarity and usability. Every pixel
                                    serves a
                                    purpose
                                    in our pursuit of functional beauty.</p>
                                <a href="#contact" class="service-tag">Explore</a>
                            </div>
                        </div>

                        <div class="asymmetric-grid fade-in">
                            <div class="service-large">
                                <h3>Art Direction</h3>
                                <p>Guiding visual narratives with restraint and intention. We believe the most
                                    powerful
                                    statements
                                    are often the quietest ones.</p>
                                <a href="#contact" class="service-tag">Discover</a>
                            </div>
                            <div class="service-small">
                                <div class="service-number">03</div>
                                <h4>Vision Focused</h4>
                            </div>
                        </div>
                    </div>
                </section>

                <!-- Section 4: Contact -->
                <section id="contact" class="contact">
                    <div class="container">
                        <div class="contact-grid fade-in">
                            <div class="contact-info">
                                <h2>Connect</h2>
                                <div class="info-item">
                                    <h4>Email</h4>
                                    <p>hello@minimal.com</p>
                                </div>
                                <div class="info-item">
                                    <h4>Phone</h4>
                                    <p>+1 234 567 890</p>
                                </div>
                                <div class="info-item">
                                    <h4>Location</h4>
                                    <p>Carrera Blanca, Skyrim</p>
                                </div>
                            </div>

                            <div class="contact-divider"></div>

                            <div class="contact-form">
                                <form>
                                    <div class="form-group">
                                        <input type="text" placeholder=" " required>
                                        <label>Name</label>
                                    </div>
                                    <div class="form-group">
                                        <input type="email" placeholder=" " required>
                                        <label>Email</label>
                                    </div>
                                    <div class="form-group">
                                        <textarea rows="4" placeholder=" " required></textarea>
                                        <label>Message</label>
                                    </div>
                                    <button type="submit" class="submit-btn">Send</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </section>

                <!-- Footer -->
                <footer>
                    <p>© 2025 Minimal Studio — Designed by <a href="https://www.tooplate.com" target="_blank"
                            rel="nofollow noopener" style="color: #009aff; font-weight: 700;">Tooplate</a></p>
                </footer>
                <script src="tooplate-minimal-script.js"></script>
    </body>

</html>