const sqlite3 = require('sqlite3').verbose();
const db = new sqlite3.Database('amigos.db');

function all(query) {
  return new Promise((resolve, reject) => {
    db.all(query, (err, rows) => {
      if (err) {
        reject(err);
      } else {
        resolve(rows);
      }
    });
  });
}

all('select * from cuates')
.then(rows => {
  console.log('Nombre Calificación');
  for (let row of rows) {
    console.log(row.nombre, row.calificacion);
  }
})
.then(() => {
  let nombre = 'Pilirica';
  let calif = 10;
  db.run('insert into cuates values (?, ?)', [nombre, calif], err => {
    if (err) {
      throw err;
    }
  });
})
.catch(err => {
  console.log('Error:', err);
});
