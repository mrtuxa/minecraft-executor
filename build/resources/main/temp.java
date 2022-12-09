ProcessBuilder processBuilder = new ProcessBuilder("uname", "-a");
        Process process = null;
        try {
        process = processBuilder.start();
        } catch (IOException e) {
        throw new RuntimeException(e);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while (true) {
        try {
        if ((line = reader.readLine()) == null) break;
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
        player.sendMessage(line);