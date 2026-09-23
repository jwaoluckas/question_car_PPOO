# Documentação do uso de IA — Questão 5 (Composite)

Conforme o enunciado, a IA foi usada para pedir **um passo-a-passo**, não a
solução pronta. Abaixo estão os prompts utilizados, o que veio de resposta e os
ajustes feitos por cima.

---

## Prompt 1 — estudo dos conteúdos da disciplina

Prompt usado uma vez, no início da lista, para revisar os padrões antes de
começar a resolver:

> Use a extensão Claude in Chrome para fazer o seguinte:
> - Entre no Classroom e veja todos os conteúdos relacionados a disciplina
>   PPOO, assim você poderá explicar melhor cada padrão que o professor ensinou
>   até agora.
> - Ainda no Classroom, veja os conteúdos da turma arquivada de Programação
>   Orientada a Objetos (POO), assim você poderá me relembrar todos os conceitos
>   de OO. Não nego, estou enferrujado!
> - Não faça nenhuma alteração, envio de mensagem ou algo que possa me
>   'prejudicar' nas turmas, apenas visualize os conteúdos e me ensine.

---

## Prompt 2 — o roteiro da solução

> Estou implementando o padrão Composite num exercício sobre um carro composto
> por partes (carroceria, chassi, trem de força, e por aí vai, cada peça com
> nome e peso). Coloquei o diagrama de classes que fiz em
> 'src/carro/diagrama-composite-carro.png' e o enunciado original em
> 'src/carro/lista-avaliativa-1.pdf'. Veja os dois arquivos antes de responder,
> porque o diagrama já define a estrutura que eu quero seguir. Me ajude com o
> seguinte:
> - A pasta carro já deve ser criada dentro de src, seguindo a mesma
>   organização das pastas bakery e telephone que já existem ali (pasta com o
>   mesmo nome duplicada dentro, tipo carro/carro).
> - Me explica em passos como você pensaria essa estrutura; onde entra cada
>   classe, como a árvore de peças do carro seria montada no Main, e como a
>   recursão do accumulate_weight percorre essa árvore, quero entender o
>   raciocínio pra ir implementando com minhas próprias mãos.

**Etapas sugeridas:**

1. Criar a interface comum (o *Component*) com nome, peso e a operação que
   percorre a árvore.
2. Criar a folha: a peça indivisível, com nome e peso próprios.
3. Criar o composto: guarda uma lista de componentes e repassa a chamada para
   cada filho — é aí que mora a recursão.
4. Montar a árvore no `Main` e disparar a soma a partir da raiz.

---

## Ajustes feitos sobre o que a IA respondeu

### Ajuste 1 — o total parcial virou um objeto (`WeightAccumulator`)

A sugestão era imprimir o total parcial de dentro do próprio `get_weight()`,
usando uma variável acumuladora guardada na classe da peça.

**Por que mudou:** isso deixaria `get_weight()` com duas responsabilidades — dar
o peso e imprimir — e o acumulado ficaria preso a um estado que sobrevive entre
execuções. Calcular o peso de dois carros no mesmo programa daria errado: o
segundo começaria com o total do primeiro.

O `WeightAccumulator` é passado de mão em mão pela recursão
(`accumulate_weight(accumulator)`). Com isso:

- `get_weight()` voltou a ser uma consulta pura, sem imprimir nada;
- cada cálculo usa o seu próprio acumulador, então rodar duas vezes dá o mesmo
  resultado;
- a impressão da linha exigida pelo enunciado fica num lugar só, dentro do
  `add()` do acumulador — se o formato mudar, muda em um arquivo.

### Ajuste 2 — o composto não sabe somar, só repassar

Na versão inicial o `CompositePart` somava os pesos dos filhos e depois mandava
imprimir. Ficou redundante: a folha já sabe o próprio peso.

O `accumulate_weight` do composto virou só um laço que repassa o acumulador para
cada filho. Quem soma e imprime é sempre a folha, esteja ela no primeiro ou no
terceiro nível da árvore. É isso que faz a mesma chamada funcionar para o carro
inteiro, para o chassi ou para uma roda solta.

### Ajuste 3 — a estrutura de pastas

O prompt pedia a pasta `carro` dentro de `src`, repetindo a organização do
`src.zip` do professor. Como a entrega é um repositório por questão, os `.java`
ficaram na raiz deste repositório — não faz sentido recriar aqui a árvore de
pastas que existia só para separar os três exercícios dentro do mesmo zip.

---

## Mapa: etapa → commit

| Etapa / ajuste                        | Commit                                                            |
|---------------------------------------|-------------------------------------------------------------------|
| Etapa 1 — interface do componente      | `cria a interface CarPart pensando no composite do carro`         |
| **Ajuste 1** — acumulador como objeto  | `adiciona o WeightAccumulator, que faltava pra isso compilar`     |
| Etapa 2 — folha                        | `implementa a SimplePart, a peca simples do carro (leaf)`         |
| Etapa 3 (**Ajuste 2**) — composto      | `implementa a CompositePart pra agrupar as pecas do carro`        |
| Etapa 4 — árvore no cliente            | `monta a arvore completa do carro no Main e calcula o peso total` |
| Diagrama de classes (exigido)          | `adiciona o diagrama de classes UML do composite em Mermaid` e `gera o PNG do diagrama de classes com o mermaid-cli` |
| Documentação da solução                | `escreve o README explicando o composite do carro`                |
