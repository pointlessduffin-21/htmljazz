import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';


platformBrowserDynamic().bootstrapModule(AppModule) ;{
  bootstrap: ['app-root']
  //.catch(err => console.error(err));
}
  
  