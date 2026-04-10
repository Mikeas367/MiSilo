import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { iniciarSesion } from '../../api/services';
import type { Usuario } from '../../models';

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
        <div style={{ maxWidth: '300px', margin: '50px auto' }}>
            <h2>Login MiSilo</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Usuario:</label>
                    <input 
                        type="text" 
                        name="username" 
                        value={credentials.username} 
                        onChange={handleChange} 
                        required 
                    />
                </div>
                <div style={{ marginTop: '10px' }}>
                    <label>Contraseña:</label>
                    <input 
                        type="password" 
                        name="password" 
                        value={credentials.password} 
                        onChange={handleChange} 
                        required 
                    />
                </div>
                {error && <p style={{ color: 'red' }}>{error}</p>}
                <button type="submit" style={{ marginTop: '20px', width: '100%' }}>
                    Ingresar
                </button>
            </form>
        </div>
    );
};