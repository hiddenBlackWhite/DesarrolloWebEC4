const express = require('express');
const router = express.Router();

const usuarioController = require('../controllers/usuarioController');

router.get('/login', usuarioController.mostrarFormularioLogin);

router.get('/clientes', usuarioController.mostrarVistaClientes);

router.get('/perfil', usuarioController.mostrarVistaPerfil);

router.get('/registro', usuarioController.mostrarVistaRegistro);

router.get('/home', usuarioController.mostrarVistaHome);

module.exports = router;