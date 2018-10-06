
const promesa = new Promise((resolve, reject) => {
  const aleatorio = Math.random();
  setTimeout(() => {
    if (aleatorio < 0.7) {
      resolve(['yes', aleatorio]);
    } else {
      reject(['no', aleatorio]);
    }
  }, 100);
});

console.log('Hola');
promesa.then(resultado => {
  console.log('promesa cumplida:', resultado);
})
.catch(resultado => {
  console.log('promesa NO complida:', resultado);
});
console.log('Adios.');
