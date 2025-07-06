const productos = require('../data/productos.json');

function calcularInteres({ monto, tasa, plazoMeses, tipo }) {
  const producto = productos.find(p => p.tipo === tipo);
  if (!producto) {
    throw new Error('Tipo de producto no soportado');
  }
  if (monto < producto.montoMin || monto > producto.montoMax) {
    throw new Error('Monto fuera del rango permitido');
  }
  if (tasa === 0 || plazoMeses === 0) {
    return 0;
  }
  switch (tipo) {
    case 'credito_personal':
      return monto * tasa * (plazoMeses / 12); // interés simple
    case 'cdp':
      return monto * Math.pow((1 + tasa), plazoMeses / 12) - monto; // interés compuesto
    default:
      throw new Error('Tipo de producto no soportado');
  }
}

module.exports = { calcularInteres };
