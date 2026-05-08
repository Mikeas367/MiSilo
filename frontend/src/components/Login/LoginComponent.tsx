import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { iniciarSesion } from '../../api/services';
import type { Usuario } from '../../models';
import './login.css';

export const LoginComponent = () => {
    const [credentials, setCredentials] = useState<Usuario>({ username: '', password: '' });
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setCredentials({
            ...credentials,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setError(null);
        try {
            const response = await iniciarSesion(credentials);
            
            // Si el backend devuelve { "token": "ey..." }
            const token = response.data.token;
            
            if (token) {
                // Guardamos el token en el localStorage
                localStorage.setItem('token', token);
                
                // Redirigimos al usuario a la página de pedidos o silo
                navigate('/'); 
            }
        } catch (err: any) {
            setError("Usuario o contraseña incorrectos");
            console.error("Error en el login:", err);
        }
    };

    return (
       <div className="login-container">
            <div className="login-card">
                <div className="login-header">
                    Inicio de Sesión
                </div>
                
                <form className="login-body" onSubmit={handleSubmit}>
                    {/* Campo Usuario */}
                    <div className="input-group mb-4">
                        <span className="input-group-text bg-transparent border-0">
                            <i className="bi bi-person-fill"></i>
                        </span>
                        <input 
                            type="text" 
                            className="form-control custom-input"
                            placeholder="Usuario"
                            name="username" 
                            value={credentials.username} 
                            onChange={handleChange} 
                            required 
                        />
                    </div>

                    {/* Campo Contraseña */}
                    <div className="input-group mb-4">
                        <span className="input-group-text bg-transparent border-0">
                            <i className="bi bi-lock-fill"></i>
                        </span>
                        <input 
                            type="password" 
                            className="form-control custom-input"
                            placeholder="Contraseña"
                            name="password" 
                            value={credentials.password} 
                            onChange={handleChange} 
                            required 
                        />
                    </div>

                    {error && (
                        <div className="alert alert-danger py-2 text-center" role="alert">
                            <small>{error}</small>
                        </div>
                    )}

                    <div className="text-center mt-4">
                        <button type="submit" className="btn btn-login">
                            Iniciar sesión
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};