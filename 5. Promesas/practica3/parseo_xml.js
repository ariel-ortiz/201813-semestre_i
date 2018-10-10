const fs = require('fs');
const xml2js = require('xml2js');

var parser = new xml2js.Parser();
fs.readFile('movies.xml', (err, data) => {
  if (err) {
    throw err;
  }
  parser.parseString(data, (err, result) => {
    if (err) {
      throw err;
    }
    // console.log(JSON.stringify(result, null, 2));
    console.log(result['movies']['film'][0]['director'][0]);
    console.log('Done');
  });
});