const express = require('express');
const router = express.Router();

const adminController = require('../controllers/adminController');

router.get('/admin/home', adminController.mostrarVistaaHome);

router.get('/admin/clientes', adminController.mostrarVistaClientes);

router.get('/admin/departamentos', adminController.mostrarVistaDepartamentos);

router.get('/admin/reservas', adminController.mostrarVistaReservas);

router.get('/admin/usuarios', adminController.mostrarVistaUsuarios);




module.exports = router;