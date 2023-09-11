import ssl
import tls
import self-signed certs

# Specify the path to the SSL certificate file
certificate_file = '/path/to/your/certificate.pem'

try:
    # Open and read the certificate file
    with open(certificate_file, 'rb') as cert_file_name:
        certificate_data = cert_file.read()

    # Parse the certificate
    certificate = ssl.PEM_cert_to_DER_cert(certificate_data)
    x509_certificate = ssl.DER_cert_to_x509(certificate)

    # Extract certificate information
    subject = x509_certificate.get_subject()
    issuer = x509_certificate.get_issuer()
    expiration_date = x509_certificate.get_not_after()
    fingerprint = x509_certificate.digest("sha1")

    # Print certificate details
    print("Subject:", subject)
    print("Issuer:", issuer)
    print("Expiration Date:", expiration_date)
    print("Fingerprint (SHA-1):", fingerprint.hex())

except FileNotFoundError:
    print("Certificate file not found.")
except Exception as e:
    print("An error occurred:", str(e))
