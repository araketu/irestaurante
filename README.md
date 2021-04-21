## Projeto de POO 2021/1

## Como montar o ambiente de desenvolvimento
1. Instalar o mongodb e MongoDB 4.4.3 Community o
2. Configurar o mongodb para rodar -> localhost:27017
3. Criar uma Data base no MongoDB Community com o nome -> 'irestaurante'
4. Criar um coleção com o nome -> POO
5. Subir o Banco
6. Rodar o Arquivo -> 'irestauranteApplication.java'


## Linguagem utilizada e Bibliotecas
1. Java -> 8;
2. SpringBoot -> 2.2. 1 
3. MongoDB -> MongoDB 4.4.3 Community

## Endpoints
1. GET - http://localhost:8080/restaurantes/ - Retorna restaurantes
2. POST - http://localhost:8080/restaurantes/ - Retorna o Endereço que foi salvo
3. DELETE - http://localhost:8080/restaurantes/{id} - Deleta um Restaurante por ID
4. Put - http://localhost:8080/restaurantes/{id} - Atuliza as informacoes do restaurante
5. GET - http://localhost:8080/cardapios/{id} - Retorna um item do cardapio pelo ID
6. GET - http://localhost:8080/cardapios/buscaporcomida?text={palavra para pesquisar} - Busca uma comida no cardapios e volta em qual restaurante tem ele



Integrantes do Grupo |Matricula
-------|------:
Diogo Ghizoni de Almeida | 1821082011
Wili Ragner Gasparetto | 2012082060 
Tiago do Nascimento Batista | 1922082016
Edinilson Pereira de Sousa | 1922082019
