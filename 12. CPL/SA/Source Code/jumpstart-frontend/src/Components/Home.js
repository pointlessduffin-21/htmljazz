import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';

const Home = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:9583/api/store/all')
            .then(response => {
                setProducts(response.data);
            })
            .catch(error => {
                console.error('There was an error!', error);
            });
    }, []);

    return (
        <div>
            <h1>Home</h1>
            {products.map((product) => (
                <Card style={{ width: '18rem', margin: '10px' }} key={product.id}>
                    <Card.Img variant="top" src={product.image_link} />
                    <Card.Body>
                        <Card.Title>{product.name}</Card.Title>
                        <Card.Text>
                            {product.description}
                            <br/>
                            Store: {product.store}
                            <br/>
                            Price: {product.price}
                        </Card.Text>
                        <Button variant="primary" onClick={() => window.location.href=`/product/${product.id}`}>Go to Product Page</Button>
                    </Card.Body>
                </Card>
            ))}
        </div>
    );
};

export default Home;
