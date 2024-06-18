const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const api = require('./src/api');

const app = express();
const port = process.env.PORT || 8080;

app.use(bodyParser.json());
app.use(cors());

// API-Routen
app.use('/api', api);

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});