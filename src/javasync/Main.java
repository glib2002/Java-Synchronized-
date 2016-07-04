/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package javasync;

import java.io.File;
import java.net.MalformedURLException;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class Main {

    private static final String PLAYLIST = "http://www.ex.ua/playlist/73602083.m3u";

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {
        File downloads = new File("./downloads/");
        downloads.mkdir();
        
        LinkStore linkStore = new LinkStore(PLAYLIST);

        for (int i = 0; i < 3; i++) {
            DownloadTask downloadTask = new DownloadTask(linkStore, downloads);
            Thread thread = new Thread(downloadTask);
            thread.start();
        }

        new Thread(linkStore).start();
    }

}
