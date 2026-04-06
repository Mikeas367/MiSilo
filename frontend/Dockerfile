# 1. Etapa de compilación (Node.js)
FROM node:20-alpine as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# 2. Etapa de producción (Nginx para servir los archivos)
FROM nginx:stable-alpine
# Copiamos la carpeta 'dist' que genera Vite al servidor Nginx
COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]