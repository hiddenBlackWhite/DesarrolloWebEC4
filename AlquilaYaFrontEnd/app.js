const express = require('express');
const app = express();


app.set('view engine', 'ejs');


app.use(express.static('public'));

// Agregar middleware para parsear el cuerpo de las solicitudes
app.use(express.urlencoded({ extended: true }));


// Importar las rutas de usuarios
const usuariosRoutes = require('./routes/usuarioRoutes');
app.use(usuariosRoutes);

// Importar las rutas de admin
const adminRoutes = require('./routes/adminRoutes')
app.use(adminRoutes);


// Iniciar el servidor
const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Servidor iniciado en el puerto ${PORT}`);
});