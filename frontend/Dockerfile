FROM node:16.15.0-alpine

WORKDIR /srv/front

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 5173

RUN chown -R node:node /srv/front/node_modules

CMD ["npm", "run", "dev"]