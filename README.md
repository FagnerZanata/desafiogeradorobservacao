# desafiogeradorobservacao

## Aspectos negativos do código original.

1. O código é de dificil leitura num primeiro momento.
2. Se faz o uso da variavel de classe "texto" sem necessidade.
3. Nome das variaveis e metodos não são autoexplicativos.
4. Não usa padrão de nomeclatura, como por exemplo a constante "umaNota".
5. Retirado alguns comentarios que nao agregam entendimento.

## Desenvolvimento e Mudanças

1. Primeiramente entendido o sistema original e esclarecido a nova necessidade.
2. Criado teste unitario para o sistema original com cenario de singular e plural.
3. Refatorado o codigo mantendo o mesmo funcioando do sistema original, testes unitarios garatiram as alteracoes.
4. Definida uma nova classe para usar na entrada do sistema, notaFiscalSR.
5. Aplicada a mudanca de entrada de dados atráves de TDD.
6. Entrada do sistema continua como Lista, mas observando qual o tipo de dado de entrada. Escolhida essa abordagem para manter o funcionando original conforme pedido no exercicio.
7. Aplicado refatoracao conforme a necessidades do desenvolvimento, como por exemplo as funcoes "isUltimaNota" e "isPenultimaNota" afim de manter o metodo "retornaInformacoesNotas" mais limpo.
 
 
## Classes
* GeradorObservacao : Sistema original
* GeradorObservacaoRefatorado : Sistema novo


## Ambiente
* Utilizado Java 11 e IDE Eclipse.
* Compilacao e execucao: mvn clean install









