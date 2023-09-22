import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Button, Modal, Form } from 'react-bootstrap';
import axios from 'axios';

const Home = () => {
    const [products, setProducts] = useState([]);
    const [filteredProducts, setFilteredProducts] = useState([]);
    const [selectedProduct, setSelectedProduct] = useState(null);
    const [search, setSearch] = useState('');
    const [showSortModal, setShowSortModal] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:9583/api/store/all')
            .then(response => {
                setProducts(response.data);
                setFilteredProducts(response.data);
            })
            .catch(error => {
                console.error('There was an error!', error);
            });
    }, []);

    useEffect(() => {
        setFilteredProducts(
            products.filter(product =>
                product.name.toLowerCase().includes(search.toLowerCase()) ||
                product.store.toLowerCase().includes(search.toLowerCase()) ||
                product.description.toLowerCase().includes(search.toLowerCase()) ||
                product.category.name.toLowerCase().includes(search.toLowerCase()) ||
                product.price.toString() === search
            )
        );
    }, [search, products]);

    const handleShow = (product) => {
        setSelectedProduct(product);
    };

    const handleClose = () => {
        setSelectedProduct(null);
    };

    const handleSortModalShow = () => {
        setShowSortModal(true);
    };

    const handleSortModalClose = () => {
        setShowSortModal(false);
    };

    return (
        <Container>
            <Form.Control
                type="text"
                placeholder="Search..."
                onChange={e => setSearch(e.target.value)}
                value={search}
                style={{marginBottom: '20px'}}
            />
            {/* <Button onClick={handleSortModalShow}>Sort</Button> */}
            <Row>
                {filteredProducts.map((product, index) => (
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
                            <p><b style={{fontSize: 'small'}}>Store:</b> </p>
                            <p>{selectedProduct.store}</p>
                            <p><b style={{fontSize: 'small'}}>Price:</b> </p>
                            <p>${selectedProduct.price}</p>
                            <p><b style={{fontSize: 'small'}}>Category:</b> </p>
                            <p>{selectedProduct.category.name}</p>   
                            <p><b style={{fontSize: 'small'}}>Description:</b></p>
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

            {/* <Modal show={showSortModal} onHide={handleSortModalClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Sort Options</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <p>Here you can add your sorting options.</p>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleSortModalClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal> */}
        </Container>
    );
};

export default Home;
