def file = new File('D:/dev/mb/ei-monorepo/ei-angular/apps/ei-web/src/app/xero/xero-frame.component.ts')
file.text = file.text.replace("'/xero'", "'/'")