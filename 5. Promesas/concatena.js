const promisify = require('promisify-node');
const fs = promisify("fs");

/*
function readFile(nombre) {
  return new Promise((resolve, reject) => {
    fs.readFile(nombre, 'utf-8', (err, data) => {
      if (err) {
        reject(err);
      } else {
        resolve(data);
      }
    });
  });
}
*/

console.log('Hola');

Promise.all([fs.readFile('uno.txt', 'utf-8'),
             fs.readFile('dos.txt', 'utf-8'),
             fs.readFile('tres.txt', 'utf-8')])
.then(valores => {
  return fs.writeFile('cuatro.txt', valores[0] + valores[1], 'utf-8');
})
.catch(err => {
  console.log(err);
});

console.log('Adios');
