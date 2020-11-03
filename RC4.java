import java.math.BigInteger;

public class RC4 {

    public static void main(String[] args) {

        String encrypt = "cebe8965697af1ee998d719fd968db8271fadbca6a7c783fccdafe6c869e12176760df836d529c00d1687465ab2feb358ee4ebea9fdc25e2a4a9b31405e39e8777a9be2aafee97f36d09adbc53394275b0fe3a915f9e41e2dace4bb8f751c36ea965f0f35eb62ebe95eed15feba99ffbb1fcd9e506842c953c3b8b7497f5550f37494129f588ea264f177930c64d71a25b9ccd73a5193c8f9421124d3599349ae319295d7f599c1d8ef1ca7f598b68f10b899cbc587c679f908163ee151e69c7af4038296042998f77ae82ec8289a269a95535ab8cf122f7a16857db1c5c112fea6d999b002863186cf12bfdaf6eeba6cfd4b36217402034c780ffa385133277c740eed132060ff8d44cb80859be0b7457c1e202e562de51a8c868a66dc6027e3c2935f1fd2087bf0b4f1d92960acbf2063318e5972c6f0eaa1669a22271325e7339d6407c5c2fdb475c1896e806a849d267591d2b75733672985dccdaa8d4b6c68925a91734790fed82e18d3a047eb189386f4ac79f2c1b6cdae791fbc7c8a6d8630179ece0185225598596af023f48496169acd4b09e913fb6db31112caef01257778bba5eb0390ff93f3c5a84018e4e810e002cc418ea5227145fb027e536358add8da997d9cf4f83d783b522d9a8abf888f026bac4f6abc0cab14cf96d271583152cc3150d41b7048967ac543baa403ba192b94b8babdabf38799773b529d8aa8e70c99cb384ff387fcc0b940de14b45f2771e988265701e84d72f1ba36384bd7a63a3a5c905426765ab2ec0db6032e216d4a21c3ca65666b65d92da9ab184133f3bcab8f46d70c8f839b6b3dba029ab9d024c23cb885e69ce0bc9793d4999a9e0a197d5600f1d15a72773b261ca71098a1ec0361888f4f2d1207e36d119aef4c7b62d87b05673a97134692981e0f254549dd59b50966e7826277f9c46e09225beea1a29cdb54b6b18238befdf2a7909bb39e1bc2a8d3085b79778629e7685f81a62ea3cdfd642f08a78cb644ede664e79aa4a566870bf2424a93561b5b9bf907a0e023213280407ed2f0bdf9e6b6709081c2e173e6d1427716287ec0d88777561114b55f17173709f58faae7e91593609b098c8925c8fc5862f988b1bcf0e083bfecec206040f4540981c9a11a63d201d79a91de3e5a8c1605550587ae4e54b462784890113b79ff71f8e826c93fcc988741e7cdc7cf27c90362af483b0765efecaaf99a2a5d29cf1777d5f6ba25deae7281347efbc3f2c1cbb0c5d5cffca2119ce275e39165b11d17991f0000aa7b0d3794215d28bb56c6ee7c21f3c07ca24868b980f717deb9c0fecf8f98eb25d56388312ac7d7790a5c02c90924ac19e626a341c1ac55812659406b6941f64c08af64587e01be67ba070b848b1f99ed01b29d1b50188e6c8a353129d57bcd52d80fa756b53ecd6bf4d89aec6bb2f13f529dd1c1cf38bc8504ec036477497482a17115905aa930029cf5173504bacc00aa09f4ebd0fb6e5eb281f53407c1c25c511b72d9b8b00e67590346bc93a112a5c63768efa62bf86ab6f18ab0bf43a208f073e0fe529e159d98b1e6201efe7cd36dfdfaf2a3f841a797b362961cbc7f221557599b4f56bfe0fb5a2c4e0f061c482011b056e574bb3c4367bf8850932b7c743ea4c944da2";

        //System.out.println(encrypt.length());

        int[] arr = new int[256];
        String keyS = "IStillKnowWhatYouDidLastSummer";
        //String encrypt = "IStillKnowWhatYouDidLastSummer";
        String[] key = keyS.split("");

        for (int i = 0; i < 256; i++) {
            arr[i] = i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + arr[i] + key[i % key.length].charAt(0)) % 256;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        byte[] byteS = encrypt.getBytes();
        byte[] plain = new byte[byteS.length];

        int i = 0;
        j = 0;

        for(int x = 0; x<encrypt.length(); x++){
            i = (i+1) % 256;
            j = (j+arr[i]) % 256;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            int t = (arr[i]+arr[j])%256;
            int k = arr[t];
            plain[x] =  (byte) (k^ byteS[x]);

//           ct[jj] = (byte) (k ^ pt[jj]);

        }

        String result = plain.toString();

        String str2 = new String(result);

        
      
        System.out.println(plain[0] +" "+plain[1]);

       

        
    }
}
