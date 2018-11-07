import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Testes {


    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Testes.class.
                                getResourceAsStream(args[0])));
        List<LayoutArquivo> inputList = br.lines().map(mapToItem).collect(Collectors.toList());

        List<LayoutArgument> arguments = new ArrayList<>();

        int saida = 0;
        int i = 1;
        while(i < args.length){
            LayoutArgument argument= new LayoutArgument();
            argument.productID = args[i++];
            argument.qntPedido = Integer.parseInt(args[i++]);
            arguments.add(argument);
        }



        double soma = 0;

        for(int k = 0; k < arguments.size(); k++){
            String produtoID = null;
            for(int j=0;j<inputList.size() && (produtoID == null);j++){
                if(arguments.get(k).productID.equals(inputList.get(j).productID)){
                    produtoID = arguments.get(k).productID;

                    soma += inputList.get(j).price;
                }
            }
            if(produtoID!=null){

            }


        }






    }

    private static String findProductID(){
        arguments.get(k).productID;
    }


    private static Function<String, LayoutArquivo> mapToItem = (line) -> {

        String[] saida = line.split(",");

        LayoutArquivo dto = new LayoutArquivo();

        dto.productID = (saida[0]);
        dto.stock = (Integer.parseInt(saida[1]));
        dto.price = (Double.parseDouble(saida[2]));

        return dto;
    };

    private static class LayoutArquivo {
        private String productID;
        private int stock;
        private double price;

        @Override
        public String toString(){
            return productID + " - " + stock + " - " + price;
        }
    }

    private static class LayoutArgument{
        private String productID;
        private int qntPedido;
    }
}
