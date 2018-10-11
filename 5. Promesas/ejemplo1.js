function makePromise() {
  return new Promise((resolve, reject) => {
    const aleatorio = Math.random();
    setTimeout(() => {
      if (aleatorio < 0.7) {
        resolve(['yes', aleatorio]);
      } else {
        reject(['no', aleatorio]);
      }
    }, 100);
  });
}

const promesa = makePromise();

console.log('Hola');
promesa.then(resultado => {
  console.log('promesa 1 cumplida:', resultado);
  return Promise.reject('valor');
})
.then(resultado => {
  console.log('promesa 2 cumplida:', resultado);
  return makePromise();
})
.catch(resultado => {
  console.log('promesa NO complida 1:', resultado);
  return makePromise();
})
.then(resultado => {
  console.log('promesa 3 cumplida:', resultado);
  return makePromise();
})
.catch(resultado => {
  console.log('promesa NO complida 2:', resultado);
  return 42;
}).
then(resultado => {
  console.log('resultado:', resultado);
});
console.log('Adios.');
