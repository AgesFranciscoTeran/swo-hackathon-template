const productos = require('../data/productos.json');
const { calcularInteres } = require('../services/calculoInteresService');

const simularInteres = (req, res) => {
  const { tipo, monto } = req.body;
  const producto = productos.find(p => p.tipo === tipo);

  if (!producto) return res.status(404).json({ error: 'Producto no encontrado' });

  if (monto < producto.montoMin || monto > producto.montoMax) {
    return res.status(400).json({ error: 'Monto fuera de rango permitido' });
  }

  const interes = calcularInteres({
    monto,
    tasa: producto.tasa,
    plazoMeses: producto.plazoMeses,
    tipo: producto.tipo
  });

  res.json({ interes, total: monto + interes });
};

module.exports = { simularInteres };
