'use strict';

const fs = require('fs');
let contenido = '';

fs.readFile('movies.csv', (err, data) => {
  if (err) {
    throw err;
  }
  contenido = data.toString();
  console.log(contenido);
});
