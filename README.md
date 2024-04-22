# Desafío Conversor de monedas.

## Descripcion

Este proyecto se trata de un conversor de monedas que se conecta a una API de tasas de cambio.
Caracteristicas:

- Disponible para cualquier moneda.
- Guarda un historial de conversiones.
- Se conecta a una API para obtener la tasa de cambio actual.

## Requerimientos

### Librerias

Vamos a necesitar dos librerias alojadas en el repositorio de maven:

- ['gson'](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1) para gestionar la conexion a la API.
- ['dotenv-java'](https://central.sonatype.com/artifact/io.github.cdimascio/dotenv-java/2.2.3) para manipular las variables de entorno.

### Archivos extra.

External Requirements:

- Vamos a registrarnos en ['ExchangeRateAPI'](https://www.exchangerate-api.com/) y vamos a obtener nuestra api key.

- Vamos a crear un archivo `.env` en la raiz de nuestro proyecto y dentro de el vamos a crear una variable llamada `API_KEY` y asignarle nuestra api key obtenida de la siguiente manera:

```sh
API_KEY=aquiTuApiKey
```


### Capturas.
<p align="center">
  
![menu_principal](https://github.com/arturoo-dev/exchangeChallenge/assets/68787405/fe3972b5-b8b7-489f-a62c-d7f5e112e2d5)

![convertir moneda](https://github.com/arturoo-dev/exchangeChallenge/assets/68787405/6e906cd4-2313-4ee5-99f0-fffda3af24c4)

![historial](https://github.com/arturoo-dev/exchangeChallenge/assets/68787405/da6c2403-cfd6-49a2-b362-f6a827720b45)

</p>
