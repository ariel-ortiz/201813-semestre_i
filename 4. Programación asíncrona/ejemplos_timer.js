console.log('Inicio');
setTimeout(() => console.log('¡Tiempo!'), 1000);
setTimeout(() => {
  console.log('Ja ja ja');
  setTimeout(() => console.log('Ha ha ha'), 1000);
}, 300);
console.log('Final');