# Aplicativo AMU (Apoio Mulher)
> Atividade de Estudo Programada - Aplicativo para segurança da mulher.

Essa aplicação foi desenvolvida para Atividade de Estudo Programada do 2º Semestre de 2021 da turma de Análise e Desenvolvimento de Sistemas da Unicesumar Londrina - PR.
A proposta era desnvolver uma solução que ajudasse a mulher, vítima de violência doméstica, a acionar a autoridade competente para que auxiliásse na sua proteção, com foco em mulheres que já possuíssem medida protetiva. O aplicativo funcionaria como um botão do pânico onde a mulher poderia acionar de forma rápida quando se sentisse ameaçada.

## Resumo da Aplicação
A proposta do grupo foi de desenvolver uma aplicação que não necessitasse de internet e o caminho escolhido para tal, foi o de propor a comunicação via MMS, desta forma o dispositivo necessitaria apenas de um pacote de MMS disponibilizado pelas autoridades responsáveis pela proteção da mulher.
Demais soluções e funcionalidades propostas no projeto:
- Acionamento da emergência via botão do pânico.
- Acionamento da emergência via comando de voz.
- Acionamento  da emergência via aproximação do suspeito dentro do limite delimitado pela medida protetiva (somente em casos onde fosse possível obter a localização do suspeito, ex: tornozeleira).
- Quando fornecida a medida protetiva, os dados da vítima seriam automaticamente preenchidos através de comunicação com uma API disponibilizada pelas autoridades.
- Possiibilidade de adicionar contatos de emergência, para que estes também sejam contatados.
- Possibilidade de cadastrar ocerrências e visualizar seus status.
- Botão para ligar para a guarda municipal.
- Contatos e informações sobre o CAM (Centro de Atendimento à Mulher).
- Aplicativo de calculadora para mascarar o aplicativo principal

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

## Como instalar
teste
