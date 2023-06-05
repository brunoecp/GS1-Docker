# GreenHeart
Projeto desenvolvido para a Global Solutions.

## Endpoint 1: Práticas Agrícolas

- Cadastrar Praticas Agrícolas
- Ler Praticas Agrícolas
- Atualizar Praticas Agrícolas
- Apagar Praticas Agrícolas

`POST` GreenHeart/api/v1/praticas

**Exemplo de Entrada**

```js
{
    "id": 1,
    "metodosCultivo": "Policultura, Permacultura, Agricultura urbana, Cobertura do solo, entre outras.",
    "tecnicasSolo": "Aração, Gradagem, Escarificação, Calagem e correção do solo",
    "tecnicasIrrigacao": "Irrigação localizada, Irrigação por aspersão, Fertirrigação por aspersão",
    "fertilizantes": "Fertilizante Foliar em Pó ou Líquido, Fertilizante Granulado, Fertilizante Farelado",
    "tiposAgricultura": "Agricultura intensiva, Agricultura extensiva, Agricultura comercial, Agricultura sustentável, entre outras."
}
```

**Campos de Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| o id das práticas agrícolas 
|metodosCultivo|sim|String| os métodos de cultivos utilizados para melhor aproveitamento 
|tecnicasSolo|sim|String| técnicas de solo para um cultivo mais produtivo, deve possuir até 5000 caracteres
|tecnicasIrrigacao|sim|String| detalhes para realização de técnicas de irrigação, deve possuir até 5000 caracteres
|fertilizantes|sim|String| fertilizantes utilizados no cutivo de aimentos
|tiposAgricultura|sim|String| detalhes de tipos de agriculturas, deve possuir até 5000 caracteres


**Códigos da Resposta**

|código|descrição
|-|-
201 | as práticas agícolas foram cadastradas com sucesso
400 | os dados enviados são invalidos

---

### Detalhar Práticas Agrícolas

`GET` GreenHeart/api/v1/praticas/{id}


**Exemplo de Resposta**

***Práticas Agrícolas ID: 1***
```js
{
    "praticas_agricola": {
        "id": 1,
        "metodosCultivo": "Policultura, Permacultura, Agricultura urbana, Cobertura do solo, entre outras.",
        "tecnicasSolo": "Aração, Gradagem, Escarificação, Calagem e correção do solo",
        "tecnicasIrrigacao": "Irrigação localizada, Irrigação por aspersão, Fertirrigação por aspersão",
        "fertilizantes": "Fertilizante Foliar em Pó ou Líquido, Fertilizante Granulado, Fertilizante Farelado",
        "tiposAgricultura": "Agricultura intensiva, Agricultura extensiva, Agricultura comercial, Agricultura sustentável, entre outras."
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados das práticas agrícolas foram retornados
404 | não existe prática agrícola com o ID

---

## Endpoint 2: Tecnologias Agrícolas

- Cadastrar Tecnologias Agrícolas
- Ler Tecnologias Agrícolas
- Atualizar Tecnologias Agrícolas
- Apagar Tecnologias Agrícolas

`POST` GreenHeart/api/v1/tecnologias

**Exemplo de Entrada**

```js
{
    "id": 2,
    "equipamentos": "Drones e VANTS, Avanços na Robótica, Máquinas agrícolas inteligentes e autônomas, Sensores, Software de gestão e monitoramento agrícola",
    "monitoramento": "Use o GPS, Invista no SIG, Invista num software de Agricultura de Precisão, Invista na sua própria estação meteorológica, Melhore seu gerenciamento de dados com Big Data"
}
```

**Campos de Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| o id das tecnologias agrícolas 
|equipamentos|sim|String| os equipamentos usados nas tecnologias agrícolas
|monitoramento|sim|String| monitoramento das técnicas usadas em plantações


**Códigos da Resposta**

|código|descrição
|-|-
201 | as Tecnologias Agrícolas foram cadastradas com sucesso
400 | os dados enviados são invalidos

---

### Detalhar Tecnologias Agrícolas

`GET` GreenHeart/api/v1/tecnologias/{id}

**Exemplo de Resposta**

***Tecnologias Agrícolas ID: 2***

```js
{
    "tecnologias_agrícolas": {
        "id": 2,
        "equipamentos": "Drones e VANTS, Avanços na Robótica, Máquinas agrícolas inteligentes e autônomas, Sensores, Software de gestão e monitoramento agrícola",
        "monitoramento": "Use o GPS, Invista no SIG, Invista num software de Agricultura de Precisão, Invista na sua própria estação meteorológica, Melhore seu gerenciamento de dados com Big Data"
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados das tecnologias agrícolas foram retornados
404 | não existe tecnologia com o ID

---

## Endpoint 3: Gestão de Recursos

- Cadastrar Gestão de Recursos
- Ler Gestão de Recursos
- Atualizar Gestão de Recursos
- Apagar Gestão de Recursos

`POST` GreenHeart/api/v1/gestao

**Exemplo de Entrada**

```js
{
    "id": 3,
    "importanciaGestao": "mais valor, produtividade e lucros no agronegócio",
    "praticasConservacao": "prevenção da erosão acelerada através da redução do impacto antropogénico, aumentar a resistência do solo à destruição pelo vento e pela água, estimulação da restauração do solo, aumentando a fertilidade das terras erodidas."
}
```

**Campos de Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| o id do produtor agrícola
|importanciaGestao|sim|String| descrição das importâncias de gestão de rescurso
|praticasConservacao|sim|String| práticas de conservação utilizadas

**Códigos da Resposta**

|código|descrição
|-|-
201 | a gestão nde rescursos foram cadastradas com sucesso
400 | os dados enviados são invalidos

---

### Detalhar Gestão de Recursos

`GET` GreenHeart/api/v1/gestao/{id}


**Exemplo de Resposta**

***Gestão de Recursos ID: 3***

```js
{
    "gestao_de_recursos": {
        "id": 3,
        "importanciaGestao": "mais valor, produtividade e lucros no agronegócio",
        "praticasConservacao": "prevenção da erosão acelerada através da redução do impacto antropogénico, aumentar a resistência do solo à destruição pelo vento e pela água, estimulação da restauração do solo, aumentando a fertilidade das terras erodidas."
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados da gestão de recursos foram retornados
404 | não existe gestão com este nome

---

## Endpoint 4: Infraestrutura Rural

- Cadastrar Infraestrutura Rural
- Ler Infraestrutura Rural
- Atualizar Infraestrutura Rural
- Apagar Infraestrutura Rural

`POST` GreenHeart/api/v1/infrarural

**Exemplo de Entrada**

```js
{
    "id": 4,
    "infraAdequada": "Arco Norte: menor distância entre as áreas de produção, no Estado do Mato Grosso e os portos exportadores, o que também se verifica na nova fronteira agrícola do MATOPIBA.",
    "planejamentoRotas": "Gerenciamento da evolução da lavoura (planejado x executado) em tempo real, Planejamento do calendário de atividades para o ano agrícola, Automação de processos (administrativos, operacionais, estoques e armazéns) e análises de performances",
    "controleTemperatura": "Telas de sombreamento, Ventilação natural, Nebulização, entre outras práticas",
    "embalagensAdequadas": "Caixas e Sacos",
    "controleQualidade": "Preparação do solo, Pulverização, Embalagem e logística",
    "manuseio": "Utilizar métodos de cultivos adequados a cada cultura, visando evitar perdas durante esta fase.",
    "monitoramentoRastreio": "Controle de produtividade, Redução de custos",
    "rotatividadeEstoque": "Direcione os produtos adequadamente e evite perdas, Busque formas adequadas de armazenamento, Certifique-se do registro de toda entrada e saída",
    "importanciaProd": "existem diferentes tipos de produção agrícola adotados. Alguns com tecnologias modernas, outros mais tradicionais. No site GreenHeart todos tem acesso a essas diversidades",
}
```

**Campos de Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| o id da infraestrutura rural
|infraAdequada|sim|String| infraestrutura rural adequada para cultivo
|planejamentoRotas|sim|String| planejamento de rotas necessario para melhor produção agrícola
|controleTemperatura|sim|String| controlar a temperatura de tudo o que cultivado pelos produtores agrícolas 
|embalagensAdequadas|sim|String| embalagens adequadas para que não ocorra nenhum tipo de desperdício 
|controleQualidade|sim|String| qualificar sempre que todos produtos cultivados são de ótima qualidade para todos os usuários 
|manuseio|sim|String| qualificar melhor manuseio de produção
|monitoramentoRastreio|sim|String| promover a transparência nos negócios e comprovar a origem dos alimentos
|rotatividadeEstoque|sim|String| garantir que nunca acabe o estoque de alimentos e que ocorra rotatividade dos produtos
|importanciaProd|sim|String| existem diferentes tipos de produção agrícola adotados. Alguns com tecnologias modernas, outros mais tradicionais. No site GreenHeart todos tem acesso a essas diversidades

**Códigos da Resposta**

|código|descrição
|-|-
201 | Infraestrutura Rural foi aplicada com sucesso
400 | os dados enviados são invalidos

---

### Detalhar Infraestrutura Rural

`GET` GreenHeart/api/v1/infrarural/{id}


**Exemplo de Resposta**

***Infraestrutura Rural ID: 4***

```js
{
    "infraestrutura_rural": {
        "id": 4,
        "infraAdequada": "Arco Norte: menor distância entre as áreas de produção, no Estado do Mato Grosso e os portos exportadores, o que também se verifica na nova fronteira agrícola do MATOPIBA.",
        "planejamentoRotas": "Gerenciamento da evolução da lavoura (planejado x executado) em tempo real, Planejamento do calendário de atividades para o ano agrícola, Automação de processos (administrativos, operacionais, estoques e armazéns) e análises de performances",
        "controleTemperatura": "Telas de sombreamento, Ventilação natural, Nebulização, entre outras práticas",
        "embalagensAdequadas": "Caixas e Sacos",
        "controleQualidade": "Preparação do solo, Pulverização, Embalagem e logística",
        "manuseio": "Utilizar métodos de cultivos adequados a cada cultura, visando evitar perdas durante esta fase.",
        "monitoramentoRastreio": "Controle de produtividade, Redução de custos",
        "rotatividadeEstoque": "Direcione os produtos adequadamente e evite perdas, Busque formas adequadas de armazenamento, Certifique-se do registro de toda entrada e saída",
        "importanciaProd": "existem diferentes tipos de produção agrícola adotados. Alguns com tecnologias modernas, outros mais tradicionais. No site GreenHeart todos tem acesso a essas diversidades"
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados sobre Infraestrutura Rural foram retornados
404 | não existe Infraestrutura Rural com o ID

---

## Endpoint 5: Variedades

- Cadastrar Variedades
- Ler Variedades
- Atualizar Variedades
- Apagar Variedades

`POST` GreenHeart/api/v1/variedades

**Exemplo de Entrada**

```js
{
    "id": 5,
    "desenvolvimento": "O desenvolvimento agrícola promove as condições adequadas para o cultivo, de forma que o plantio, a colheita e o processamento das safras sejam feitos de maneira eficaz.",
    "culturasClima": "cada cultura tem uma condição ideal para que sua germinação, emergência e desenvolvimento ocorram da melhor forma possível.",
    "importanciaCulturas": "novas culturas agrícolas surgiram no panorama agrícola nacional, diversificando o sector e trazendo novas oportunidades sobretudo para quem chega à agricultura ou quer reconverter e alargar as suas opções culturais"
}
```

**Campos de Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| o id de variedades foi cadastrado
|desenvolvimento|sim|String| desenvolvimento das variedades no campo
|culturasClima|sim|String| identificar qual melhor clima para tal plantação
| importanciaCulturas|sim|String| quais as importâncias devem ser tomadas para exportar os alimentos para determinada região do planeta, ou seja, levar em consideração a cultura de cada país

**Códigos da Resposta**

|código|descrição
|-|-
201 | o dados de variedade foram atualizados com sucesso
400 | os dados enviados são invalidos

---

### Detalhar Variedades

`GET` GreenHeart/api/v1/variedades/{id}


**Exemplo de Resposta**

***Variedades ID: 5***

```js
{
    "variedades": {
        "id": 5,
        "desenvolvimento": "O desenvolvimento agrícola promove as condições adequadas para o cultivo, de forma que o plantio, a colheita e o processamento das safras sejam feitos de maneira eficaz.",
        "culturasClima": "cada cultura tem uma condição ideal para que sua germinação, emergência e desenvolvimento ocorram da melhor forma possível.",
        "importanciaCulturas": "novas culturas agrícolas surgiram no panorama agrícola nacional, diversificando o sector e trazendo novas oportunidades sobretudo para quem chega à agricultura ou quer reconverter e alargar as suas opções culturais"
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados das variedades foram retornados
404 | não existe variedade com o ID 

---

## Endpoint 6: Proteínas Vegetais

- Cadastrar Proteínas Vegetais
- Ler Proteínas Vegetais
- Atualizar Proteínas Vegetais
- Apagar Proteínas Vegetais

`POST` GreenHeart/api/v1/proteinas

**Exemplo de Entrada**

```js
{
    "id": 6,
    "tiposProteinas": "Feijão, Sementes de abóbora, Grão de soja, Castanha de caju",
    "prodCustos": "O custo de produção agrícola é uma excepcional ferramenta de controle e gerenciamento das atividades produtivas e de geração de importantes informações para subsidiar as tomadas de decisões pelos produtores rurais."
}
```

**Campos de Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| o id da proteína obtida pelo usuário
|tiposProteinas|sim|String| quais proteínas devem ser usadas nas produções, ou seja, ocorre a substituição de carne animal por pantação natural
|prodCustos|sim|String| gastos usados nas produções agrícolas

**Códigos da Resposta**

|código|descrição
|-|-
201 | o dados das proteinas foram atualizados com sucesso
400 | os dados enviados são invalidos

---

### Detalhar Doenças

`GET` GreenHeart/api/v1/proteinas/{id}


**Exemplo de Resposta**

***Proteínas Vegetais ID: 6***

```js
{
    "doenca": {
        "id": 6,
        "tiposProteinas": "Feijão, Sementes de abóbora, Grão de soja, Castanha de caju",
        "prodCustos": "O custo de produção agrícola é uma excepcional ferramenta de controle e gerenciamento das atividades produtivas e de geração de importantes informações para subsidiar as tomadas de decisões pelos produtores rurais."
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados das proteínas foram retornados
404 | não existe proteína com este ID 

---

## Endpoint 7: Insetos Comestíveis

- Cadastrar Insetos Comestíveis
- Ler Insetos Comestíveis
- Atualizar Insetos Comestíveis
- Apagar Insetos Comestíveis

`POST` GreenHeart/api/v1/insetos

**Exemplo de Entrada**

```js
{
    "id": 7,
    "sobreCultura": "Agricultura de Subsistência, Agricultura Orgânica, etc",
}
```

**Campos de Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| o id do inseto  comestível
|sobreCultura|sim|String| São responsáveis pela propagação de plantas através da polinização e da dispersão de sementes, promovendo assim o fluxo gênico ao manter a base genética das plantas

**Códigos da Resposta**

|código|descrição
|-|-
201 | o dados relacionados aos insetos comestíveis foram atualizados com sucesso
400 | os dados enviados são invalidos

---

### Detalhar Insetos Comestíveis

`GET` GreenHeart/api/v1/insetos/{id}


**Exemplo de Resposta**

***Insetos Comestíveis ID: 7***

```js
{
    "insetos_comestíveis": {
        "id": 7,
        "sobreCultura": "Agricultura de Subsistência, Agricultura Orgânica, etc",
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados dos insetos foram retornados
404 | não existe inseto com este ID

---

## Endpoint 8: Alimentos Alternativos

- Cadastrar Alimentos Alternativos
- Ler Alimentos Alternativos
- Atualizar Alimentos Alternativos
- Apagar Alimentos Alternativos

`POST` GreenHeart/api/v1/alimentosalt

**Exemplo de Entrada**

```js
{
    "id": 8,
    "tiposFontesAlt": "Energia Hídrica, Energia Eólica, Energia Solar, Energia das Marés, Energia Geotérmica",
    "beneficiosFontesAlt": "Altos índices de produção, Qualidade e segurança alimentar, Eficiência no uso de insumos, Redução dos custos gerais, Melhora na qualidade do trabalho dos profissionais ligados à área, Diminuição dos impactos ao meio ambiente." 
}
```

**Campos de Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|:-------------:|-------|-----------|
|id|sim|int| o id do alimento alternativo
|tiposFontesAlt|sim|String| todas as fontes de alimentos alternativos que podem ser usadas
|beneficiosFontesAlt|sim|String| todos os beneficios que o produtor tem depois que utiliza as fontes alternativas em suas produções

**Códigos da Resposta**

|código|descrição
|-|-
201 | o dados dos alimentos alternativos foram atualizados com sucesso
400 | os dados enviados são invalidos

---

### Detalhar Alimentos Alternativos

`GET` GreenHeart/api/v1/alimentosalt/{id}


**Exemplo de Resposta**

***Alimentos Alternativos ID: 8***

```js
{
    "alimentos_alternativos": {
        "id": 8,
        "tiposFontesAlt": "Energia Hídrica, Energia Eólica, Energia Solar, Energia das Marés, Energia Geotérmica",
        "beneficiosFontesAlt": "Altos índices de produção, Qualidade e segurança alimentar, Eficiência no uso de insumos, Redução dos custos gerais, Melhora na qualidade do trabalho dos profissionais ligados à área, Diminuição dos impactos ao meio ambiente." 
    }
}
```

**Códigos da Resposta**

|código|descrição
|-|-
200 | os dados dos alimentos foram retornados
404 | não existe alimento com este ID 



