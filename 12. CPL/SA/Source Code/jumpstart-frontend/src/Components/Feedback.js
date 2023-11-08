import React, { useState } from 'react';
import { Container, Form, Button } from 'react-bootstrap';
import axios from 'axios';

const Feedback = () => {
    const [feedbackData, setFeedbackData] = useState({
        name: '',
        issue_type: '',
        issue_title: '',
        issue_description: '',
        issue_steps: '',
        issue_expected: '',
        issue_actual: ''
    });

    const handleChange = (e) => {
        setFeedbackData({
            ...feedbackData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://100.77.207.39:8080/api/feedback/add', feedbackData)
            .then((response) => {
                console.log(response);
                setFeedbackData({
                    name: '',
                    issue_type: '',
                    issue_title: '',
                    issue_description: '',
                    issue_steps: '',
                    issue_expected: '',
                    issue_actual: ''
                });
            })
            .catch((error) => {
                console.log(error);
            });
    };

    return (
        <Container className="my-5 px-5">
            <h2 className="text-center mb-5 fw-bolder">Feedback</h2>
            <p className="text-center lead mb-0">Have a complaint? Paste them here.</p>
            <Form id="feedbackForm" onSubmit={handleSubmit}>
                <Form.Group className="mb-3">
                    <Form.Label>Name</Form.Label>
                    <Form.Control type="text" id="name" name="name" value={feedbackData.name} onChange={handleChange} required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Issue Type</Form.Label>
                    <Form.Control type="text" id="issue_type" name="issue_type" value={feedbackData.issue_type} onChange={handleChange} required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Issue Title</Form.Label>
                    <Form.Control type="text" id="issue_title" name="issue_title" value={feedbackData.issue_title} onChange={handleChange} required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Issue Description</Form.Label>
                    <Form.Control type="text" id="issue_description" name="issue_description" value={feedbackData.issue_description} onChange={handleChange} required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Issue Steps</Form.Label>
                    <Form.Control type="text" id="issue_steps" name="issue_steps" value={feedbackData.issue_steps} onChange={handleChange} required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Issue Expected</Form.Label>
                    <Form.Control type="text" id="issue_expected" name="issue_expected" value={feedbackData.issue_expected} onChange={handleChange} required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Issue Actual</Form.Label>
                    <Form.Control type="text" id="issue_actual" name="issue_actual" value={feedbackData.issue_actual} onChange={handleChange} required />
                </Form.Group>
                <Button type="submit" className="btn btn-primary">Submit</Button>
                <br />
            </Form>
        </Container>
    );
};

export default Feedback;
