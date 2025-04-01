function Login() {
    return (
        <div className="container mt-5">
            <h2>User Login</h2>
            <form>
                <div className="mb-3">
                    <label>Email</label>
                    <input type="email" className="form-control" placeholder="Enter email" />
                </div>
                <div className="mb-3">
                    <label>Password</label>
                    <input type="password" className="form-control" placeholder="Enter password" />
                </div>
                <button type="submit" className="btn btn-primary">Login</button>
            </form>
        </div>
    );

}
export default Login;