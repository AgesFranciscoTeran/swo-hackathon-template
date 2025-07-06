const express = require('express');
const simuladorRoutes = require('./routes/simuladorRoutes');

const app = express();
app.use(express.json());
app.use('/api', simuladorRoutes);

app.listen(3000, () => {
  console.log('Servidor corriendo en http://localhost:3000');
});
