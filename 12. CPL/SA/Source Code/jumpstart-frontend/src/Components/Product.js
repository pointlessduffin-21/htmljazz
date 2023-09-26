import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Product = ({ match }) => {
    const [product, setProduct] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:9583/api/store/${match.params.id}`)
            .then(response => {
                setProduct(response.data);
            })
            .catch(error => {
                console.error('There was an error!', error);
            });
    }, [match.params.id]);

    return product ? (
        <div>
            <h1>{product.name}</h1>
            <p>Store: {product.store}</p>
            <p>Price: ${product.price}</p>
            <img src={`http://localhost:9583/api/image/${product.id}`} alt="Product" />
        </div>
    ) : (
        <p>Loading...</p>
    );
};

export default Product;
