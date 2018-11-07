/*

Para generar el par de llaves pública (autofirmada) y privada, desde la
terminal teclear el siguiente comando:

    openssl req -nodes -new -x509 -keyout ~/server.key -out ~/server.cert

*/

const https = require('https');
const fs = require('fs');
const express = require('express');

const app = new express();

const opciones = {
  key: fs.readFileSync('/home/ec2-user/server.key'),
  cert: fs.readFileSync('/home/ec2-user/server.cert')
};

app.get('/hello', (req, res) => {
  res.type('text').send('Hello World!\n');
});

https.createServer(opciones, app)
.listen(process.env.PORT, () => {
  console.log('Server running as: ' + "https://" + process.env.C9_HOSTNAME + ":" + process.env.PORT + "/hello");
});
