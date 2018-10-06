const fs = require("fs");

fs.readFile('uno.txt', 'utf-8', (err, data) => {
  if (err) {
    throw err;
  }
  fs.writeFile('tres.txt', data, 'utf-8', err => {
    if (err) {
      throw err;
    }
    fs.readFile('dos.txt', 'utf-8', (err, data) => {
      if (err) {
        throw err;
      }
      fs.appendFile('tres.txt', data, 'utf-8', err => {
        if (err) {
          throw err;
        }
        console.log('Done.');
      });
    });
  });
});
