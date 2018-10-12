var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express',
                        titulo: 'Express'
                      });
});

module.exports = router;

router.get('/hola', (req, res) => {
  res.render('hola', { titulo: 'Saludos' });
});

router.get('/loquesea', (req, res) => {
  res.render('loquesea', { titulo: 'Lo Que Sea' });
});