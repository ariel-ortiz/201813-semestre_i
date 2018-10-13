var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

module.exports = router;

router.get('/prueba', (req, res) => {
  res.render('prueba', {});
});

router.get('/procesa', (req, res) => {
  //console.log(req.query);
  let nombre = req.query.nombre.trim() || 'Juan';
  let apellido = req.query.apellido.trim() || 'Camaney';
  let email = req.query.email.trim() || 'jcamaney@example.com';
  res.render('listo', { nombre, apellido, email });
});

router.post('/procesa', (req, res) => {
  //console.log(req.query);
  //console.log(req.body);
  req.session.nombre = (req.body.nombre || 'Juan').trim();
  req.session.apellido = (req.body.apellido || 'Camaney').trim();
  req.session.email = (req.body.email || 'jcamaney@example.com').trim();
  // Redirect after post
  res.redirect('/fin'); // GET
});

router.get('/fin', (req, res) => {
  let nombre = req.session.nombre;
  let apellido = req.session.apellido;
  let email = req.session.email;
  res.render('listo', { nombre, apellido, email });
});