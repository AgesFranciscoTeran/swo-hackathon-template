const express = require('express');
const router = express.Router();
const { simularInteres } = require('../controllers/simuladorController');

router.post('/simular', simularInteres);

module.exports = router;
