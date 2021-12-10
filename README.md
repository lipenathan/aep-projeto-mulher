# Aplicativo AMU (Apoio Mulher)
> Atividade de Estudo Programada - Aplicativo para segurança da mulher.

Essa aplicação foi desenvolvida para Atividade de Estudo Programada do 2º Semestre de 2021 da turma de Análise e Desenvolvimento de Sistemas da Unicesumar Londrina - PR.
A proposta era desenvolver uma solução que ajudasse a mulher, vítima de violência doméstica, a acionar a autoridade competente para que auxiliasse na sua proteção, com foco em mulheres que já possuíssem medida protetiva. O aplicativo funcionaria como um botão do pânico onde a mulher poderia acionar de forma rápida quando se sentisse ameaçada.

- [Resumo da Aplicação](#resumo-da-aplicação)
- [Funcionalidades Implementadas](#funcionalidades-implementadas)
- [Observações](#observacães)
- [Tecnologias e bibliotecas Usadas](#tecnologias-e-bibliotecas-usadas)
- [Instalação e Uso](#instalacão-e-uso)

## Resumo da Aplicação
A proposta do grupo foi de desenvolver uma aplicação que não necessitasse de internet e o caminho escolhido para tal, foi o de propor a comunicação via MMS, desta forma o dispositivo necessitaria apenas de um pacote de MMS disponibilizado pelas autoridades responsáveis pela proteção da mulher.

Demais soluções e funcionalidades propostas no projeto:
- Acionamento da emergência via botão do pânico.
- Acionamento da emergência via comando de voz.
- Acionamento  da emergência via aproximação do suspeito dentro do limite delimitado pela medida protetiva (somente em casos onde fosse possível obter a localização do suspeito, ex: tornozeleira).
- Quando fornecida a medida protetiva, os dados da vítima seriam automaticamente preenchidos através de comunicação com uma API disponibilizada pelas autoridades.
- Possiibilidade de adicionar contatos de emergência, para que estes também sejam contatados.
- Possibilidade de cadastrar ocorrências e visualizar seus status.
- Botão para ligar para a guarda municipal.
- Contatos e informações sobre o CAM (Centro de Atendimento à Mulher).
- Aplicativo de calculadora para mascarar o aplicativo principal.

## Funcionalidades implementadas
- Base de dados portátil.
- Mapeamento completo das entidades da aplicação
- Cadastro completo da vítima, com máscaras e validações.
- Calculadora que sobrepõe o aplicativo.
- Botão que liga direto para guarda municipal (GM Londrina - PR).

## Observações
A aplicação foi desenvolvida dentro do período de 1 mês, e por diversos fatores nem todas funcionalidades foram implementadas.
O aplicativo foi desenvolvido por Felipe Nathan dos Anjos (https://github.com/lipenathan).
Demais pessoas envolvidas no projeto foram Charles Mendes de Lima e Fabio Silveira Goulart.

## Tecnologias e bibliotecas usadas
- Android Studio (IDE)
- JUnit 4.13.2 (Testes)
- mflibrary 1.0.0 (Máscaras - https://github.com/rtoshiro/MaskFormatter.git)
- SQLite (Base de dados local)

## Instalação e uso
### Vá para a pasta do apk no repositorio github em seu celular android e clique em Download.(https://github.com/lipenathan/amu-app/tree/main/apk)

<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img1.jpeg" width="367" height="800">
</p>

### Clique em abrir e então em instalar
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img2.jpeg" width="367" height="800">
</p>
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img3.jpeg" width="367" height="800">
</p>

### Aceite a instalação do app, se sentir seguro.
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img4.jpeg" width="367" height="800">
</p>

### Telas de cadastro
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img5.jpeg" width="367" height="800">
</p>
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img6.jpeg" width="367" height="800">
</p>
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img7.jpeg" width="367" height="800">
</p>
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img8.jpeg" width="367" height="800">
</p>
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img9.jpeg" width="367" height="800">
</p>
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img9.1.jpeg" width="367" height="800">
</p>
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img10.jpeg" width="367" height="800">
</p>

### Para que o app possa realizar ligações é preciso liberar acesso
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img11.jpeg" width="367" height="800">
</p>
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img12.jpeg" width="367" height="800">
</p>

### Aplicatvo de calculadora para esconder aplicação principal
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img13.jpeg" width="367" height="800">
</p>

### Digite o pin escolhido anteriormente e pressione '='
<p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img14.jpeg" width="367" height="800">
</p><p align="center">
  <img src="https://github.com/lipenathan/amu-app/blob/main/readme-images/img15.jpeg" width="367" height="800">
</p>
