from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from flask_bcrypt import Bcrypt
from flask_jwt_extended import JWTManager, create_access_token
from datetime import datetime
from flask_mysqldb import MySQL

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://yeems214:roelfrancis100@localhost/jumpstart'
app.config['JWT_SECRET_KEY'] = '\xb4B\xcfK\x95\x10L\x86$2\x8d\xcb\x0c\xb6e\x05\x07[U\xdd8\xbf^\xf0'  # Replace with your secret key

db = SQLAlchemy(app)
bcrypt = Bcrypt(app)
jwt = JWTManager(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120), nullable=False)
    username = db.Column(db.String(120), unique=True, nullable=False)
    address = db.Column(db.String(120))
    phoneNumber = db.Column(db.BigInteger)
    email = db.Column(db.String(120), unique=True, nullable=False)
    password = db.Column(db.String(120), nullable=False)
    registrationDateTime = db.Column(db.DateTime, default=datetime.utcnow)

    role_id = db.Column(db.Integer, db.ForeignKey('role.id'), nullable=False)
    role = db.relationship('Role', backref=db.backref('users', lazy=True))

    def __repr__(self):
        return f"User('{self.name}', '{self.username}', '{self.email}')"

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

@app.route("/signup", methods=["POST"])
def signup():
    email = request.json["email"]
    password = request.json["password"]

    return jsonify({
        "id": 1,
        "name": "John Doe",
        "email": email
    })

@app.route('/register', methods=['POST'])
def register():
    data = request.get_json()
    
    # Check if a user with the same username already exists
    existing_user = User.query.filter_by(username=data['username']).first()
    if existing_user:
        # If a user is found, return a message
        return jsonify({'message': 'A user with this username already exists.'}), 400
    else:
        hashed_password = bcrypt.generate_password_hash(data['password']).decode('utf-8')
        role_id = 1  # Sets the role id of a newly created user as Customer
        new_user = User(name=data['name'], username=data['username'], address=data['address'], phoneNumber=data['phoneNumber'], email=data['email'], password=hashed_password, registrationDateTime=datetime.utcnow(), role_id=role_id)
        db.session.add(new_user)
        db.session.commit()
        return jsonify({'message': 'Registered successfully'}), 201


@app.route('/login', methods=['POST'])
def login():
    data = request.get_json()
    user = User.query.filter_by(email=data['email']).first()
    if not user or not bcrypt.check_password_hash(user.password, data['password']):
        return jsonify({'message': 'Wrong credentials'}), 401

    token = create_access_token(identity=user.email)
    return jsonify({'token': token}), 200

if __name__ == "__main__":
    app.run(debug=True)