package br.una.git.first;

public class GitCriptografiaRC4 {

public String criptografa (String palavra, String chave)
{
	int contador=0;
	String palavracriptografada = "";
	
//Inicializa o vetor UM com valores da tabela ASCCII
	int S[] = new int[256];
	int T[] = new int[256];
	
	int i = 0;
	for (i=0; i < 256; i++)
		{
			S[i] =  i;
			
   		//System.out.println(S[i]);
		}
//Inicaliza vetor DOIS com valor ASCCI dos caracteres correspondentes à palavra CHAVE
	int y=0;
	for (i=0;i<256;i++)
		{
			if (y == chave.length() )
				{
					y=0;
				}
			char valorascii=chave.charAt(y);
			T[i] = valorascii;
			//System.out.println(T[i]);
			y++;
		}
//Faz permutaçao entre os valores dos vetores S e T
	int j;
	j=0;
	for (i=0;i<256;i++)
	{
		j=(j+S[i]+T[i]) % 256;
		S[i]=S[j];
		//System.out.println(S[i]);
	}
//Gera vetor do texto claro com valores correspondente em ASCII	
	int textoclaro[] = new int [palavra.length()];
	for (i=0;i<palavra.length();i++)
	{
		char valorascii=palavra.charAt(i);
		textoclaro[i] = valorascii;
		//System.out.println(textoclaro[i]);
	}

//Geração de Fluxo
//	contador ++;
//	System.out.println("contador " + contador);
	int z,k,xor;
	i=0;
	j=0;
	int t;
	String origem;
	int retorno;
	String binarioxor;
	
	for(z=0;z<palavra.length();z++)
	{
		i=(i+1) % 256;
		j=(j + S[i]) % 256;
		S[i] = S[j];
		t=(S[i] + S[j]) % 256;
		k=S[t];
		
		   
		
		//Criptografia
		  
		retorno = k^palavra.charAt(z); //EXOR
		palavracriptografada = palavracriptografada + (char)retorno;
	}	
	
	return palavracriptografada;
	
}
	public static void main(String[] args) 
	{
		String palavracriptografada;
		GitCriptografiaRC4 c = new GitCriptografiaRC4();
		palavracriptografada = c.criptografa("RONALDO", "TESTE");
		
		System.out.println("Palavra Criptografada.: " + palavracriptografada);
		
		palavracriptografada = c.criptografa(palavracriptografada, "TESTE");		
		System.out.println("Palavra DeCriptografada.: " + palavracriptografada);
	}

}

