# Stage 1: Build the Next.js app
FROM node

WORKDIR /app

COPY package.json package-lock.json ./

RUN npm install


COPY . .

EXPOSE 3000

CMD ["npm","run", "dev"]