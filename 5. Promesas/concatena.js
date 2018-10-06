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

fs.readFile('uno.txt', 'utf-8')
.then(data => {
  return fs.writeFile('tres.txt', data, 'utf-8');
})
.then(() => {
  return fs.readFile('dos.txt', 'utf-8');
})
.then(data => {
  return fs.appendFile('tres.txt', data, 'utf-8');
})
.then(() => {
  console.log('Done.');
})
.catch(err => {
  console.log(err);
});

console.log('Adios');
