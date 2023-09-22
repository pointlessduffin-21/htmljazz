import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Button, Modal } from 'react-bootstrap';
import axios from 'axios';

const Home = () => {
    const [products, setProducts] = useState([]);
    const [selectedProduct, setSelectedProduct] = useState(null);

    useEffect(() => {
        axios.get('http://localhost:9583/api/store/all')
            .then(response => {
                setProducts(response.data);
            })
            .catch(error => {
                console.error('There was an error!', error);
            });
    }, []);

    const handleShow = (product) => {
        setSelectedProduct(product);
    };

    const handleClose = () => {
        setSelectedProduct(null);
    };

    return (
        <Container>
            <Row>
                {products.map((product, index) => (
                    <Col key={index} xs={12} sm={6} md={4} lg={3}>
                        <Card>
                            <Card.Img variant="top" src={`http://localhost:9583/api/image/${product.id}`} />
                            <Card.Body>
                                <Card.Title>{product.name}</Card.Title>
                                <Card.Text>
                                    {product.store}<br/>
                                    ${product.price}
                                </Card.Text>
                                <Button variant="primary" onClick={() => handleShow(product)}>View Product</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>

            <Modal show={selectedProduct !== null} onHide={handleClose}>
                {selectedProduct && (
                    <>
                        <Modal.Header closeButton>
                            <Modal.Title>Product</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <img src={`http://localhost:9583/api/image/${selectedProduct.id}`} alt="Product" style={{width: '100%', marginBottom: '20px'}} />
                            <h4>{selectedProduct.name}</h4>
                            <p>{selectedProduct.store}</p>
                            <p>${selectedProduct.price}</p>
                            <p>{selectedProduct.category.name}</p>   
                            <p>Description: </p>
                            <p>{selectedProduct.description}</p>
                             
                        </Modal.Body>

                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>
                                Close
                            </Button>
                        </Modal.Footer>
                    </>
                )}
            </Modal>
        </Container>
    );
};

export default Home;
