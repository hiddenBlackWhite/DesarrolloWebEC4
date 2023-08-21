const path = require('path');

function mostrarVistaaHome(req, res) {
    
    const loginFilePath = path.join(__dirname, '../views/admin/index.html');
  
    res.sendFile(loginFilePath);
  }

function mostrarVistaClientes(req, res) {

    const loginFilePath = path.join(__dirname, '../views/admin/clientes.html');

    res.sendFile(loginFilePath);
}

function mostrarVistaDepartamentos(req, res) {
    
    const loginFilePath = path.join(__dirname, '../views/admin/departamentos.html');
  
    res.sendFile(loginFilePath);
  }

  
function mostrarVistaReservas(req, res) {
    
    const loginFilePath = path.join(__dirname, '../views/admin/reservas.html');
  
    res.sendFile(loginFilePath);
}


function mostrarVistaUsuarios(req, res) {
    
    const loginFilePath = path.join(__dirname, '../views/admin/usuarios.html');
  
    res.sendFile(loginFilePath);
  }

module.exports = {
    mostrarVistaaHome,
    mostrarVistaClientes,
    mostrarVistaDepartamentos,
    mostrarVistaReservas,
    mostrarVistaUsuarios
}