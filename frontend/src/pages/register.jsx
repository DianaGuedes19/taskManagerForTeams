function Register() {
    return (
        <div className="container mt-5">
            <h2>Register</h2>
            <form>
                <div className="mb-3">
                    <label>Email</label>
                    <input type="email" className="form-control" placeholder="Enter email"/>
                </div>
                <div className="mb-3">
                    <label>Username</label>
                    <input type="username" className="form-control" placeholder="Enter username"/>
                </div>
                <div className="mb-3">
                    <label>Password</label>
                    <input type="password" className="form-control" placeholder="Enter password"/>
                </div>
                <div className="mb-3">
                    <label>Type Of Account</label>
                    <input type="role" className="form-control" placeholder="Enter type of account"/>
                </div>
                <button type="submit" className="btn btn-primary">Register</button>
            </form>
        </div>
    );
}

export default Register;
