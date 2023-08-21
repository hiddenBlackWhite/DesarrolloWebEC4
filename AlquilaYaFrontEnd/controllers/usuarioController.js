const path = require('path');

function mostrarFormularioLogin(req, res) {
    
    const loginFilePath = path.join(__dirname, '../views/login.html');
  
    res.sendFile(loginFilePath);
  }

function mostrarVistaClientes(req, res) {

    const loginFilePath = path.join(__dirname, '../views/user/clientes.html');

    res.sendFile(loginFilePath);
}

function mostrarVistaPerfil(req, res) {
    
    const loginFilePath = path.join(__dirname, '../views/user/perfil.html');
  
    res.sendFile(loginFilePath);
  }

  
function mostrarVistaRegistro(req, res) {
    
    const loginFilePath = path.join(__dirname, '../views/registro.html');
  
    res.sendFile(loginFilePath);
}


function mostrarVistaHome(req, res) {
    
    const loginFilePath = path.join(__dirname, '../views/user/home.html');
  
    res.sendFile(loginFilePath);
  }

module.exports = {
    mostrarFormularioLogin,
    mostrarVistaClientes,
    mostrarVistaHome,
    mostrarVistaPerfil,
    mostrarVistaRegistro
}