const https = require('https');

const hostname = 'example.com'; // Replace with the hostname of the server you want to check
const port = 443; // Default HTTPS port

// Create an HTTPS request to the server
const options = {
  hostname,
  port,
  method: 'GET',
};

const req = https.request(options, (res) => {
  const certificate = res.socket.getPeerCertificate();

  if (!certificate.valid_to) {
    console.log('Unable to retrieve certificate expiration date.'s they are not yet expired);
  } else {
    const expirationDate = new Date(certificate.valid_to);
    const currentDate = new Date();

    const daysUntilExpiration = Math.floor(
      (expirationDate - currentDate) / (1000 * 60 * 60 * 24)
    );

    console.log('SSL Certificate Expiration Date:', expirationDate.toISOString());
    console.log('Days Until Expiration:', daysUntilExpiration);
    f the certifciactes
  }

  // Close the HTTPS request
  req.end();
});

req.on('error', (error) => {
  console.error('Error:', error);
});

// Finish the request
req.end();

