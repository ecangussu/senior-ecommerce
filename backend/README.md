SENIOR ECOMMERCE

-Projeto FullStack Java Angular.

-Objetivo: cadastro e exibição de produtos e pedidos

-Resumo do que foi feito BACKEND: CRUD completo de produtos (seleção, criação, atualização e remoção); 
seleção e inserção de pedidos contendo produtos (associação muitos para muitos); criação de 
entidades utilizando Spring JPA; criação de perfil de testes utilizando banco H2 e seeding de dados.

-Resumo do que foi feito FRONTEND: criação de 5 telas (home, tela de cadastro e exibição de produtos, 
tela de alteração e remoção de produtos, tela de cadastro e exibição resumida de pedidos, tela de relatórios
detalhados de pedidos).

-TODO: adicionar logs, try catchs, validações, testes unitários e ambiente de produção

TECNOLOGIAS UTILIZADAS

Java 17 | SpringBoot 3.2.3 | Postman deskptop 10.23.5 | Intellij 17.0.9 | Banco de dados H2 | Angular 17.1.1 | Node 20.11.0 | npm 10.2.4

COMO RODAR A APLICAÇÃO

    Clonar o projeto do GitHub: git clone git@github.com:ecangussu/senior-ecommerce.git

    1.SOMENTE BACKEND
        -Necessário instalação do Java
        -Recomendado o uso de alguma IDE (eclipse, Intellij, ...)
        -Recomendado o uso de algum software para realização de requisições HTTP (postman, ...)
        -Os dados já implementados no contexto de teste e os novos adicionados serão encontrados no banco H2: http://localhost8080/h2-console

        PRODUTO
        -Seleção de todos os produtos: curl --location 'localhost:8080/products'
        -Seleção de um produto específico de acordo com seu ID: curl --location 'localhost:8080/products/1'
        -Criação de um novo produto:
            curl --location 'localhost:8080/products' \
            --header 'Content-Type: application/json' \
            --data '{
            "name": "Motorola a54",
            "description": "celular da motorola",
            "quantity": 100,
            "price": 1500
            }'
        -Atualização de um produto:
            curl --location --request PUT 'localhost:8080/products/1' \
            --header 'Content-Type: application/json' \
            --data '{
            "name": "Motorola a94",
            "description": "Celular da Marca Motorola",
            "quantity": 200,
            "price": 1500
            }'
        -Deleção de um produto: curl --location --request DELETE 'http://localhost:8080/products/1'
        Obs.: se houver associação de um produto com um pedido não será possível deletar o produto.

        PEDIDO
        -Seleção de todos os pedidos: curl --location 'localhost:8080/products'
        -Seleção de um pedido específico de acordo com seu ID: curl --location 'localhost:8080/products/1'
        -Criação de um novo pedido:
            curl --location 'localhost:8080/orders' \
            --header 'Content-Type: application/json' \
            --data-raw '{
            "order": {
            "customerName": "José",
            "cpf": "111.111.111.-11",
            "email": "jose@gmail.com"
            },
            "productAux": [
            {
            "id": 1,
            "quantity": 2
            },
            {
            "id": 2,
            "quantity": 3
            },
            {
            "id": 3,
            "quantity": 4
            }
            ]
            }'
        Obs.: não foram adicionadas as opções de atualização e remoção, pois o correto seria cancelar o pedido e iniciar um novo,
        e não alterá-lo ou remove-lo. Fica como TODO

    2.BACKEND E FRONTEND
        -Necessário instalação do Node.js (verificar se já está instalado: node -v)
            https://nodejs.org/en/download
        -Necessário instalação Angular CLI (verificar se já está instalado: ng v)
            npm install -g @angular/cli
        -Recomendado uso de algum editor de texto (VS code)
        -Rodando o projeto: ng s
        -O sistema estará em execução em http://localhost:4200
        
Obs.: as telas de cadastro/exibição e de alteração/remoção de produtos estão funcionando, exibindo os produtos já existentes criados no 
seeding do projeto e os novos criados tanto via curl quanto via interface (exceto pelo código interno que não está aceitando a criação 
automatica no front) e alterando/atualizando e removendo os produtos conforme selecionados. A tela de cadastro/exibição de pedidos
está somente exibindo a lista de pedidos já adicionados via seeding ou então novos pedidos adicionados via curl, porém o cadastro via 
interface não está funcionando. A tela de relatórios também exibe normalmente os pedidos adicionados via seeding no código e também os 
os adicionados via curl, mas não os cadastrados via interface, já que esse fluxo não ficou pronto.

Resumindo: via backend todo o sistema está funcionando (seleção, criação, atualização e remoção de produtos e seleção e adição de pedidos)
e no front os dados já adicionados via seeding e os novos dados adicionados via curl estão sendo exibidos em todas as telas (cadastro e 
exibição de produtos, cadastro e exibição de pedidos e tela de relatórios de pedidos), porém via interface, é possível somente adicionar 
produtos (sem código interno), e não pedidos.